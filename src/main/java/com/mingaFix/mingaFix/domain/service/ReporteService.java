package com.mingaFix.mingaFix.domain.service;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;
import com.mingaFix.mingaFix.domain.exception.ReporteNotFound;
import com.mingaFix.mingaFix.persistence.repository.ReporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public List<ReporteDto> getAll() {
        return reporteRepository.findAll();
    }

    public ReporteDto getById(long id) {
        return reporteChecker(id);
    }

    public ReporteDto save(ReporteDto reporteDto) {
        return reporteRepository.save(reporteDto);
    }

    public ReporteDto update(long id, ActualizarReporteDto actualizarReporteDto) {
        return reporteRepository.update(id, actualizarReporteDto)
                .orElseThrow(() -> new ReporteNotFound(id));
    }

    public void deleteById(long id) {
        reporteChecker(id);
        reporteRepository.deleteById(id);
    }

    private ReporteDto reporteChecker(long id) {
        return reporteRepository.findById(id)
                .orElseThrow(() -> new ReporteNotFound(id));
    }
}
