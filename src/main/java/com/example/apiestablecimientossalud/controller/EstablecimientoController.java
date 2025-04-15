package com.example.apiestablecimientossalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.apiestablecimientossalud.dto.EstablecimientoDTO;
import com.example.apiestablecimientossalud.helpers.CSVHelper;
import com.example.apiestablecimientossalud.service.EstablecimientoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/establecimientos")
@RequiredArgsConstructor
public class EstablecimientoController {

    @Autowired
    private EstablecimientoService establecimientoService;
    
    // @Autowired
    // public EstablecimientoController(EstablecimientoService establecimientoService ) {
    //     this.establecimientoService = establecimientoService;
    // }

    @PostMapping
    public ResponseEntity<EstablecimientoDTO> crear(@RequestBody EstablecimientoDTO request){
        var creado = establecimientoService.create(request);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablecimientoDTO> obtenerPorId(@PathVariable Long id) {
        var establecimiento = establecimientoService.getById(id);
        return ResponseEntity.ok(establecimiento);
    }

    @GetMapping
    public ResponseEntity<List<EstablecimientoDTO>> obtenerTodos(@RequestParam(name = "page",defaultValue = "0") Integer page,
    @RequestParam(name = "size",defaultValue = "20") Integer size) {
        var lista = establecimientoService.getAll(page, size);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/categoria/{categoria}")
    public ResponseEntity<List<EstablecimientoDTO>> buscarPorCategoria(@PathVariable String categoria,
        @RequestParam(name = "page",defaultValue = "0") Integer page,
        @RequestParam(name = "size",defaultValue = "20") Integer size) {
        var lista = establecimientoService.findByCategoria(categoria, page,size);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablecimientoDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EstablecimientoDTO request){
        var actualizado = establecimientoService.update(id, request);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        establecimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (!CSVHelper.hasCSVFormat(file)) {
            message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } 

        try {
            establecimientoService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

}
