package com.mingaFix.mingaFix.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppExeption extends RuntimeException{

    private final String type;

    private final HttpStatus status;

    protected AppExeption(String type, String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.type = type;
    }
}
