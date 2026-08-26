package com.jknpp.pagamentoSimplificado.Service;


import com.jknpp.pagamentoSimplificado.Controller.TransacaoDto;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.TipoUsuario;
import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final UsuarioService usuarioService;

    public void efetuarTransacao(TransacaoDto transacaoDto){
        Usuario pagador = usuarioService.buscarUsuario(transacaoDto.pagador());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDto.recebedor());

        validarTransacao(pagador);
        validarSaldoPagador(pagador, transacaoDto.valor() );
    }

    private void validarTransacao(Usuario usuario){
        if(usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)){
            throw new IllegalArgumentException("Transação inválida para esse tipo de conta");
        }
    }

    private void validarSaldoPagador(Usuario usuario, BigDecimal valor){
        if(usuario.getCarteira().getSaldo().compareTo(valor) < 0){
            throw new IllegalArgumentException("Transação inválida por falta de saldo");
        }
    }
}
