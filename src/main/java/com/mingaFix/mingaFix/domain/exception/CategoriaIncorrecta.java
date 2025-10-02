package com.mingaFix.mingaFix.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class CategoriaIncorrecta extends AppExeption {

    public CategoriaIncorrecta(List<String> values) {
        super(
                "Categoria no valida",
                "Las categorias validas son: " + String.join(", ", values),
                HttpStatus.BAD_REQUEST
        );
    }
}
