package com.jknpp.pagamentoSimplificado.Infrastructure.Clients;

import com.jknpp.pagamentoSimplificado.Controller.AutorizacaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "autorizacao")
public interface AutorizacaoClient {

    @GetMapping
    AutorizacaoDto validarAutorizacao();
}
