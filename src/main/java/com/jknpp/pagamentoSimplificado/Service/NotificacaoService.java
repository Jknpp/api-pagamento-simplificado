package com.jknpp.pagamentoSimplificado.Service;


import com.jknpp.pagamentoSimplificado.Infrastructure.Clients.AutorizacaoClient;
import com.jknpp.pagamentoSimplificado.Infrastructure.Clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificacaoService {
    private final NotificacaoClient notificacaoClient;

    public void enviarNotificacao() {
        notificacaoClient.enviarNotificacao();
    }
}
