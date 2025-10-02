package com.mingaFix.mingaFix.domain.repository;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;

import java.util.List;
import java.util.Optional;

public interface IReporteRepository {

    List<ReporteDto> findAll();

    Optional<ReporteDto> findById(long id);

    ReporteDto save(ReporteDto reporteDto);

    Optional<ReporteDto> update(long id, ActualizarReporteDto ActualizarReporteDto);

    void deleteById(long id);
}
