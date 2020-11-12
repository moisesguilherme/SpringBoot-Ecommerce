package org.una.sdm.aula09.exceptions;

public class CategoriaException extends RuntimeException {

    public CategoriaException(String mensagem) {
        super(mensagem);
    }

    public CategoriaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
