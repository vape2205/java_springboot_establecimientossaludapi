package com.example.apiestablecimientossalud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstablecimientoDTO {
    private Long id_eess;
    private String codigo_renaes;
    private String categoria;
    private String nombre;
    private String diresa;
    private String red;
    private String direccion;
    private Double longitud;
    private Double latitud;
    private int id_ubigeo;
}
