package com.mingaFix.mingaFix.persistence.mapper;

import com.mingaFix.mingaFix.domain.dto.ReporteDto;
import com.mingaFix.mingaFix.domain.dto.update.ActualizarReporteDto;
import com.mingaFix.mingaFix.persistence.entity.ReporteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReporteMapper {

    @Mapping(source = "photo", target = "url")
    @Mapping(source = "category", target = "categoria")
    @Mapping(source = "latitude", target = "latitud")
    @Mapping(source = "longitude", target = "longitud")
    ReporteDto toDto(ReporteEntity reporteEntity);

    List<ReporteDto> toDtoList(Iterable<ReporteEntity> reporteEntities);

    @InheritInverseConfiguration
    ReporteEntity toEntity(ReporteDto reporteDto);

    @Mapping(source = "url", target = "photo")
    @Mapping(source = "categoria", target = "category")
    @Mapping(source = "latitud", target = "latitude")
    @Mapping(source = "longitud", target = "longitude")
    void updateReporte(ActualizarReporteDto actualizarReporteDto, @MappingTarget ReporteEntity reporteEntity);
}
