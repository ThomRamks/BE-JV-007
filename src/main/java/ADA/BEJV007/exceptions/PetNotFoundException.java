package ADA.BEJV007.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(){
        super ("Pet não encontrado.");
    }
}
