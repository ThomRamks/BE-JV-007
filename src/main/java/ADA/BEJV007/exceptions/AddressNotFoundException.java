package org.example.exceptions;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(){
        super("Endereco não encontrado.");
    }
}
