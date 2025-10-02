package com.mingaFix.mingaFix.domain.dto.update;

import com.mingaFix.mingaFix.domain.translate.Categorias;
import jakarta.validation.constraints.*;

public record ActualizarReporteDto(
        @NotBlank(message = "La URL de la foto no puede ser vacia")
        @Pattern(
                regexp = "^(http|https)://.*$",
                message = "La URL debe ser valida y comenzar con http o https"
        )
        String url,

        @NotBlank(message = "La categoría es obligatoria")
        @Size(max = 100, message = "La categoría no puede superar los 100 caracteres")
        Categorias categoria,

        @NotNull(message = "La latitud es obligatoria")
        @DecimalMin(value = "-90.0", inclusive = true, message = "La latitud mínima es -90.0")
        @DecimalMax(value = "90.0", inclusive = true, message = "La latitud máxima es 90.0")
        Double latitud,

        @NotNull(message = "La longitud es obligatoria")
        @DecimalMin(value = "-180.0", inclusive = true, message = "La longitud mínima es -180.0")
        @DecimalMax(value = "180.0", inclusive = true, message = "La longitud máxima es 180.0")
        Double longitud
) {
}
