package com.example.apiestablecimientossalud.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.apiestablecimientossalud.dto.EstablecimientoDTO;

public interface EstablecimientoService {
    List<EstablecimientoDTO> getAll(Integer page, Integer size);
    EstablecimientoDTO getById(Long id);
    EstablecimientoDTO create(EstablecimientoDTO dto);
    EstablecimientoDTO update(Long id, EstablecimientoDTO dto);
    void delete(Long id);
    void save(MultipartFile file);
    List<EstablecimientoDTO> findByCategoria(String categoria, Integer page, Integer size);
}
