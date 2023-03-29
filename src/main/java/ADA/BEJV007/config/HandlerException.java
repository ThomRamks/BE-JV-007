package ADA.BEJV007.config;

import ADA.BEJV007.dto.ErrorDTO;
import ADA.BEJV007.exceptions.ProfileNotFoundException;
import ADA.BEJV007.exceptions.AddressNotFoundException;
import ADA.BEJV007.exceptions.PetNotFoundException;
import ADA.BEJV007.exceptions.SameCpfException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfileNotFoundException.class)
    public ErrorDTO handlerProfileNotFound(ProfileNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PetNotFoundException.class)
    public ErrorDTO handlerPetNotFound(PetNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AddressNotFoundException.class)
    public ErrorDTO handlerAddressNotFound(AddressNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(SameCpfException.class)
    public ErrorDTO handlerSameCpf(SameCpfException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

}