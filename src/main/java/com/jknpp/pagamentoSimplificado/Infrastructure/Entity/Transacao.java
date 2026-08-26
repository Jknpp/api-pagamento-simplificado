package com.jknpp.pagamentoSimplificado.Infrastructure.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @JoinColumn(name = "pagador_id")
    @ManyToOne
    private Usuario pagador;

    @JoinColumn(name = "recebedor_id")
    @ManyToOne
    private Usuario recebedor;

    private LocalDateTime dataHoraTrasacao;

    @PrePersist
    void prePersist(){
        dataHoraTrasacao = LocalDateTime.now();
    }

}
