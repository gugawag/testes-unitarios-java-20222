package org.example;

public class ContaExistenteException extends RuntimeException {
    public ContaExistenteException(String mensagem) {
        super(mensagem);
    }
}
