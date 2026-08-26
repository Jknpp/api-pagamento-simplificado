package com.jknpp.pagamentoSimplificado.Service;

import com.jknpp.pagamentoSimplificado.Infrastructure.Clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {
    private final AutorizacaoClient autorizacaoClient;

    public boolean validarTransferencia(){
        if(Objects.equals(autorizacaoClient.validarAutorizacao().data().authorization(), true)){
            return true;
        }
        return false;
    }
}
