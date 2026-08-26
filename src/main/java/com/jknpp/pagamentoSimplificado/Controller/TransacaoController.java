package com.jknpp.pagamentoSimplificado.Controller;

import com.jknpp.pagamentoSimplificado.Service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transferencia")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> realizarTransacao(@RequestBody TransacaoDto transacaoDto){
        transacaoService.efetuarTransacao(transacaoDto);
        return ResponseEntity.accepted().build();
    }
}
