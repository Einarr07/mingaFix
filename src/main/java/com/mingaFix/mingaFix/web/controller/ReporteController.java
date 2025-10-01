package com.mingaFix.mingaFix.web.controller;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;
import com.mingaFix.mingaFix.domain.service.ReporteService;
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

    @GetMapping("/todos")
    public ResponseEntity<List<ReporteDto>> all() {
        return ResponseEntity.ok(reporteService.getAll());
    }

    @GetMapping("/unico/{id}")
    public ResponseEntity<ReporteDto> unico(@PathVariable long id) {
        return ResponseEntity.ok(reporteService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ReporteDto> crear(@RequestBody ReporteDto reporteDto) {
        return new ResponseEntity<>(reporteService.save(reporteDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReporteDto> actualizar(@PathVariable long id, @RequestBody ActualizarReporteDto reporteDto) {
        return ResponseEntity.ok(reporteService.update(id, reporteDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ReporteDto> eliminar(@PathVariable long id) {
        reporteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
