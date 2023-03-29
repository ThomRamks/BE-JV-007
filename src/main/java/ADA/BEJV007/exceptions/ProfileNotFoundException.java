package org.example.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    public ProfileNotFoundException(){
        super("Usuário não encontrado.");
    }
}
