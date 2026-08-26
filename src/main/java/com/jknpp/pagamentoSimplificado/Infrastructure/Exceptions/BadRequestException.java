package com.jknpp.pagamentoSimplificado.Infrastructure.Exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
