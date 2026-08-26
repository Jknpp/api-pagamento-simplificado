package com.jknpp.pagamentoSimplificado.Service;

import com.jknpp.pagamentoSimplificado.Controller.TransacaoDto;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Carteira;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.TipoUsuario;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Transacao;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Usuario;
import com.jknpp.pagamentoSimplificado.Infrastructure.Exceptions.BadRequestException;
import com.jknpp.pagamentoSimplificado.Infrastructure.Repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final CarteiraService carteiraService;
    private final TransacaoRepository transacaoRepository;
    private final NotificacaoService notificacaoService;


    @Transactional
    public void efetuarTransacao(TransacaoDto transacaoDto){
        Usuario pagador = usuarioService.buscarUsuario(transacaoDto.pagador());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDto.recebedor());

        validarTransacao(pagador);
        validarSaldoPagador(pagador, transacaoDto.valor());
        validarTransferencia();

        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDto.valor()));
        atualizarSaldoCarteira(pagador.getCarteira());

        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoDto.valor()));
        atualizarSaldoCarteira(recebedor.getCarteira());

        Transacao transacao =  Transacao.builder()
                .valor(transacaoDto.valor())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        transacaoRepository.save(transacao);
        enviarNotificacao();

    }

    private void validarTransacao(Usuario usuario){
        if(usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)){
            throw new BadRequestException("Lojistas não podem realizar transferências.");
        }
    }

    private void validarSaldoPagador(Usuario usuario, BigDecimal valor){
        if(usuario.getCarteira().getSaldo().compareTo(valor) < 0){
            throw new BadRequestException("Saldo insuficiente");
        }
    }

    private void validarTransferencia(){
        if(!autorizacaoService.validarTransferencia()){
            throw new BadRequestException("Transferência não autorizada.");
        }
    }

    private void atualizarSaldoCarteira(Carteira carteira){
        carteiraService.salvar(carteira);
    }

    private void enviarNotificacao(){
        try {
            notificacaoService.enviarNotificacao();
        } catch (Exception e) {
            log.error("Erro ao enviar notificação", e);
        }
    }
}
