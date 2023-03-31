package ADA.BEJV007.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String parametro){
        super (parametro + " não encontrado");
    }

}
