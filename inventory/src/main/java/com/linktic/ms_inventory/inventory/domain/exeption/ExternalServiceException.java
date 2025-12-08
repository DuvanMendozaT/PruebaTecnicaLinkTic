package com.linktic.ms_inventory.inventory.domain.exeption;

public class ExternalServiceException extends RuntimeException {
    public ExternalServiceException(String message) {
        super(message);
    }
}