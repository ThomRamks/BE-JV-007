package org.example.exceptions;

public class SameCpfException extends RuntimeException {
    public SameCpfException() {
        super("Este CPF já está cadastrado.");
    }
}
