package com.mingaFix.mingaFix.domain.dto;

import com.mingaFix.mingaFix.domain.translate.Categorias;

public record ReporteDto(
        Long idReporte,
        String url,
        Categorias categoria,
        Double latitud,
        Double longitud
) {
}
