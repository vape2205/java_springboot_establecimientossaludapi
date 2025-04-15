package com.example.apiestablecimientossalud.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiestablecimientossalud.model.Establecimiento;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {

    List<Establecimiento> findByCategoria(String categoria, Pageable pageable);
}
