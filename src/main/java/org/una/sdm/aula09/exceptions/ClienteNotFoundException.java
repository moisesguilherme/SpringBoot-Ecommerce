package org.una.sdm.aula09.exceptions;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException() {
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
