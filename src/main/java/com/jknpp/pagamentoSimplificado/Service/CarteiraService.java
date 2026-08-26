package com.jknpp.pagamentoSimplificado.Service;

import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Carteira;
import com.jknpp.pagamentoSimplificado.Infrastructure.Repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {
    private final CarteiraRepository carteiraRepository;

    public void salvar(Carteira carteira){
        carteiraRepository.save(carteira);
    }
}
