package com.jugtechday.cft.domain.core.exception;

public class CftDomainException extends RuntimeException {

    public CftDomainException(String message) {
        super(message);
    }

    public CftDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
