package com.example.apiestablecimientossalud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Establecimiento {
    @Id
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
