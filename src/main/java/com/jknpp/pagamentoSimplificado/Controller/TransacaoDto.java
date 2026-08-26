package com.jknpp.pagamentoSimplificado.Controller;

import java.math.BigDecimal;

public record TransacaoDto (BigDecimal valor, Long pagador, Long recebedor) {
}
