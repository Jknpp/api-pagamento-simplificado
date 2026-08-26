package com.jknpp.pagamentoSimplificado.Infrastructure.Repository;

import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
