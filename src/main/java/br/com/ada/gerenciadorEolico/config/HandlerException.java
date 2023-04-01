package br.com.ada.gerenciadorEolico.config;

import br.com.ada.gerenciadorEolico.dto.ErrorDTO;
import br.com.ada.gerenciadorEolico.exceptions.AerogeradorNotFoundException;
import br.com.ada.gerenciadorEolico.exceptions.AerogeradorNumeroSerieException;
import br.com.ada.gerenciadorEolico.exceptions.ParqueEolicoNotFoundException;
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
    @ExceptionHandler({AerogeradorNotFoundException.class, ParqueEolicoNotFoundException.class})
    public ErrorDTO handlerAerogeradorNotFound(Exception ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AerogeradorNumeroSerieException.class)
    public ErrorDTO handlerAerogeradorConflito(AerogeradorNumeroSerieException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }


}
