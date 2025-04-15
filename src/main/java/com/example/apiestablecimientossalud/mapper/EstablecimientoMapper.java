package com.example.apiestablecimientossalud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.apiestablecimientossalud.dto.EstablecimientoDTO;
import com.example.apiestablecimientossalud.model.Establecimiento;

@Mapper(componentModel = "spring")
public interface EstablecimientoMapper {
    
    EstablecimientoMapper INSTANCE = Mappers.getMapper(EstablecimientoMapper.class);

    Establecimiento toEntity(EstablecimientoDTO dto);

    EstablecimientoDTO toDTO(Establecimiento domain);

    List<EstablecimientoDTO> toDTOList(List<Establecimiento> list);
}
