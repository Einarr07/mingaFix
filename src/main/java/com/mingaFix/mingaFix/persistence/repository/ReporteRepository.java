package com.mingaFix.mingaFix.persistence.repository;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;
import com.mingaFix.mingaFix.domain.repository.IReporteRepository;
import com.mingaFix.mingaFix.persistence.crud.ICrudReporteEntity;
import com.mingaFix.mingaFix.persistence.entity.ReporteEntity;
import com.mingaFix.mingaFix.persistence.mapper.IReporteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReporteRepository implements IReporteRepository {

    private final ICrudReporteEntity crudReporteEntity;
    private final IReporteMapper reporteMapper;

    @Override
    public List<ReporteDto> findAll() {
        return reporteMapper.toDtoList(crudReporteEntity.findAll());
    }

    @Override
    public Optional<ReporteDto> findById(long id) {
        return crudReporteEntity.findById(id).map(reporteMapper::toDto);
    }

    @Override
    public ReporteDto save(ReporteDto reporteDto) {
        ReporteEntity reporteEntity = reporteMapper.toEntity(reporteDto);

        return reporteMapper.toDto(crudReporteEntity.save(reporteEntity));
    }

    @Override
    public Optional<ReporteDto> update(long id, ActualizarReporteDto actualizarReporteDto) {
        return crudReporteEntity.findById(id).map(reporteEntity -> {
            reporteMapper.updateReporte(actualizarReporteDto, reporteEntity);
            return reporteMapper.toDto(crudReporteEntity.save(reporteEntity));
        });
    }

    @Override
    public void deleteById(long id) {
        crudReporteEntity.deleteById(id);
    }
}
