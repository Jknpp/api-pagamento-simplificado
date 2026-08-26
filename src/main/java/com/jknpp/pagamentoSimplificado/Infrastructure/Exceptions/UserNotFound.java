package com.jknpp.pagamentoSimplificado.Infrastructure.Exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
}
