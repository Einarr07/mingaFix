package com.mingaFix.mingaFix.domain.exception;

import org.springframework.http.HttpStatus;

public class ReporteNotFound extends AppExeption{

    public ReporteNotFound(long id){
        super(
                "Reporte no encontrado",
                "El reporte con " + id + " no existe",
                HttpStatus.NOT_FOUND
        );
    }
}
