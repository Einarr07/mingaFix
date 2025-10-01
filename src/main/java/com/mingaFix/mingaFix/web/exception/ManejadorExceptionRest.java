package com.mingaFix.mingaFix.web.exception;

import com.mingaFix.mingaFix.domain.exception.AppExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManejadorExceptionRest {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerExceptionActualizacion(MethodArgumentNotValidException exception) {
        List<Error> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AppExeption.class)
    public ResponseEntity<Error> handlerAppExeption(AppExeption exception) {
        Error error = new Error(exception.getType(), exception.getMessage());
        return ResponseEntity.status(exception.getStatus()).body(error);
    }
}
