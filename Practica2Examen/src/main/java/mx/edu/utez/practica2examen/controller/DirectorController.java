package mx.edu.utez.practica2examen.controller;

import jakarta.validation.Valid;
import mx.edu.utez.practica2examen.dto.DirectorRequestDTO;
import mx.edu.utez.practica2examen.dto.DirectorResponseDTO;
import mx.edu.utez.practica2examen.model.Director;
import mx.edu.utez.practica2examen.model.Pelicula;
import mx.edu.utez.practica2examen.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @PostMapping
    public ResponseEntity<DirectorResponseDTO> registrar(@Valid @RequestBody DirectorRequestDTO dto) {
        Director director = directorService.registar(dto);
        DirectorResponseDTO response = new DirectorResponseDTO();
        response.setId(director.getId());
        response.setNombre(director.getNombre());
        response.setNacionalidad(director.getNacionalidad());
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DirectorResponseDTO>> listar() {
        List<Director> directores = directorService.listar();
        List<DirectorResponseDTO> response = directores.stream().map(director -> {
            DirectorResponseDTO dto = new DirectorResponseDTO();
            dto.setId(director.getId());
            dto.setNombre(director.getNombre());
            dto.setNacionalidad(director.getNacionalidad());
            return dto;
        }).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
