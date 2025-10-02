package com.mingaFix.mingaFix.web.controller;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;
import com.mingaFix.mingaFix.domain.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-reportes")
@AllArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @Operation(summary = "Obtener todos los reportes", description = "Devuelve una lista con todos los reportes registrados en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reportes obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReporteDto.class)))
    })
    @GetMapping("/todos")
    public ResponseEntity<List<ReporteDto>> all() {
        return ResponseEntity.ok(reporteService.getAll());
    }

    @Operation(summary = "Obtener un reporte por ID", description = "Devuelve un reporte específico usando su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReporteDto.class))),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    @GetMapping("/unico/{id}")
    public ResponseEntity<ReporteDto> unico(@PathVariable long id) {
        return ResponseEntity.ok(reporteService.getById(id));
    }

    @Operation(summary = "Crear un nuevo reporte", description = "Registra un nuevo reporte en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reporte creado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReporteDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping("/crear")
    public ResponseEntity<ReporteDto> crear(@RequestBody ReporteDto reporteDto) {
        return new ResponseEntity<>(reporteService.save(reporteDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un reporte", description = "Actualiza la información de un reporte existente usando su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte actualizado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReporteDto.class))),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReporteDto> actualizar(@PathVariable long id, @RequestBody ActualizarReporteDto reporteDto) {
        return ResponseEntity.ok(reporteService.update(id, reporteDto));
    }

    @Operation(summary = "Eliminar un reporte", description = "Elimina un reporte del sistema por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reporte eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        reporteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
