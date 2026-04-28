package mx.edu.utez.practica3examen.controller;

import jakarta.validation.Valid;
import mx.edu.utez.practica3examen.dto.VideojuegoRequestDTO;
import mx.edu.utez.practica3examen.dto.VideojuegoResponseDTO;
import mx.edu.utez.practica3examen.model.Videojuego;
import mx.edu.utez.practica3examen.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @PostMapping
    public ResponseEntity<VideojuegoResponseDTO> registrar(@Valid @RequestBody VideojuegoRequestDTO dto){
            Videojuego videojuego = videojuegoService.registrar(dto);
            VideojuegoResponseDTO response = new VideojuegoResponseDTO();
            response.setId(videojuego.getId());
            response.setTitulo(videojuego.getTitulo());
            response.setGenero(videojuego.getGenero());
            response.setPlataforma(videojuego.getPlataforma());
            response.setAnioLanzamiento(videojuego.getAnioLanzamiento());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VideojuegoResponseDTO>> listar(){
        List<Videojuego> videojuegos = videojuegoService.listar();
        List<VideojuegoResponseDTO> response = videojuegos.stream().map(videojuego -> {
            VideojuegoResponseDTO dto = new VideojuegoResponseDTO();
            dto.setId(videojuego.getId());
            dto.setTitulo(videojuego.getTitulo());
            dto.setGenero(videojuego.getGenero());
            dto.setPlataforma(videojuego.getPlataforma());
            dto.setAnioLanzamiento(videojuego.getAnioLanzamiento());
            return dto;
        }).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
