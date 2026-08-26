package com.jknpp.pagamentoSimplificado.Infrastructure.Repository;

import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
