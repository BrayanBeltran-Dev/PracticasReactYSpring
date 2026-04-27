package mx.edu.utez.examencorreccion.controller;

import jakarta.validation.Valid;
import mx.edu.utez.examencorreccion.dto.ArtistaRequestDTO;
import mx.edu.utez.examencorreccion.dto.ArtistaResponseDTO;
import mx.edu.utez.examencorreccion.model.Artista;
import mx.edu.utez.examencorreccion.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @PostMapping
    public ResponseEntity<ArtistaResponseDTO> registrar(@Valid @RequestBody ArtistaRequestDTO dto) {
        Artista artista = artistaService.registrar(dto);
        ArtistaResponseDTO response = new ArtistaResponseDTO();
        response.setId(artista.getId());
        response.setNombre(dto.getNombre());
        response.setNacionalidad(dto.getNacionalidad());
        response.setGeneroMusical(dto.getGeneroMusical());
        response.setAnioDebut(dto.getAnioDebut());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
