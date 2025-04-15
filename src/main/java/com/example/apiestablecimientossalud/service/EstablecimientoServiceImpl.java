package com.example.apiestablecimientossalud.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.apiestablecimientossalud.dto.EstablecimientoDTO;
import com.example.apiestablecimientossalud.exception.ResourceNotFoundException;
import com.example.apiestablecimientossalud.helpers.CSVHelper;
import com.example.apiestablecimientossalud.mapper.EstablecimientoMapper;
import com.example.apiestablecimientossalud.model.Establecimiento;
import com.example.apiestablecimientossalud.repository.EstablecimientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstablecimientoServiceImpl implements EstablecimientoService {
    
    @Autowired
    private EstablecimientoRepository establecimientoRepository;

    @Autowired
    private EstablecimientoMapper establecimientoMapper;

    @Override
    public List<EstablecimientoDTO> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        var list = establecimientoRepository.findAll(pageable).toList();
        return establecimientoMapper.toDTOList(list);
    }

    @Override
    public EstablecimientoDTO getById(Long id) {
        Establecimiento Establecimiento = establecimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado con id: " + id));
        return establecimientoMapper.toDTO(Establecimiento);
    }

    @Override
    public EstablecimientoDTO create(EstablecimientoDTO EstablecimientoDTO) {
        Establecimiento Establecimiento = establecimientoMapper.toEntity(EstablecimientoDTO);
        Establecimiento savedEstablecimiento = establecimientoRepository.save(Establecimiento);
        return establecimientoMapper.toDTO(savedEstablecimiento);
    }

    @Override
    public EstablecimientoDTO update(Long id, EstablecimientoDTO EstablecimientoDTO) {
        Establecimiento existingEstablecimiento = establecimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado con id: " + id));

        Establecimiento updatedEstablecimiento = establecimientoRepository.save(existingEstablecimiento);
        return establecimientoMapper.toDTO(updatedEstablecimiento);
    }

    @Override
    public void delete(Long id) {
        Establecimiento Establecimiento = establecimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado con id: " + id));
                establecimientoRepository.delete(Establecimiento);
    }

    @Override
    public void save(MultipartFile file) {
        try {
            List<Establecimiento> entities = CSVHelper.loadObjectList(Establecimiento.class, file.getInputStream());;
            establecimientoRepository.saveAll(entities);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public List<EstablecimientoDTO> findByCategoria(String categoria, Integer page, Integer size) {
        PageRequest pageable = PageRequest.of(page, size);
        var list = establecimientoRepository.findByCategoria(categoria, pageable);
        return establecimientoMapper.toDTOList(list);
    }
}
