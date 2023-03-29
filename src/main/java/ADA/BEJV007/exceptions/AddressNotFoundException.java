package ADA.BEJV007.exceptions;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(){
        super("Endereco não encontrado.");
    }
}
