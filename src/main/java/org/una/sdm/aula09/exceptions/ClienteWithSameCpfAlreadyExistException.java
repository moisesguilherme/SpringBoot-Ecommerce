package org.una.sdm.aula09.exceptions;

public class ClienteWithSameCpfAlreadyExistException extends RuntimeException {


    public ClienteWithSameCpfAlreadyExistException(String s) {
        super(s);
    }
}
