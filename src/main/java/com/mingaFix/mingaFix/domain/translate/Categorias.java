package com.mingaFix.mingaFix.domain.translate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mingaFix.mingaFix.domain.exception.CategoriaIncorrecta;

import java.util.Arrays;
import java.util.List;

public enum Categorias {
    BACHE("bache"),              // Huecos en la vía
    ALCANTARILLA("alcantarilla"),       // Problemas con alcantarillado/tapas abiertas
    ILUMINACION("iluminacion"),        // Falta o daño en luminarias públicas
    BASURA("basura"),             // Acumulación de desechos
    GRAFITI("grafiti"),            // Vandalismo/pintadas en espacios públicos
    TRANSPORTE("transporte"),         // Problemas con transporte público o paradas
    SEMAFORO("semaforo"),           // Semáforos dañados o fuera de servicio
    ARBOL_CAIDO("arbol caido"),        // Árboles caídos o ramas peligrosas
    AGUA("agua"),               // Fugas de agua potable
    ELECTRICIDAD("electricidad"),       // Postes/cables eléctricos en mal estado
    SEGURIDAD("seguridad"),          // Reportes de seguridad ciudadana
    OTRO("otro");         // Algo que no encaje en las demás categorías

    private final String value;

    Categorias(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Categorias formValue(String value) {
        for (Categorias categoria : Categorias.values()) {
            if (categoria.value.equals(value)) {
                return categoria;
            }
        }
        throw new CategoriaIncorrecta(getValidValues());
    }

    public static List<String> getValidValues() {
        return Arrays.stream(values())
                .map(Categorias::getValue)
                .toList();
    }
}
