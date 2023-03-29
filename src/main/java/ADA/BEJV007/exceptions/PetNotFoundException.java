package org.example.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(){
        super ("Pet não encontrado.");
    }
}
