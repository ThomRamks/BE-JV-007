package ADA.BEJV007.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    public ProfileNotFoundException(){
        super("Usuário não encontrado.");
    }
}
