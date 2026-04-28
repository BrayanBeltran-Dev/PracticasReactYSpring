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
    // MÉTODO PARA ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> actualizar(@PathVariable Long id, @RequestBody VideojuegoRequestDTO dto) {
        Videojuego actualizado = videojuegoService.actualizar(id, dto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado); // HTTP 200 OK
        }
        return ResponseEntity.notFound().build(); // HTTP 404 No Encontrado
    }

    // MÉTODO PARA ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = videojuegoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok().build(); // HTTP 200 OK
        }
        return ResponseEntity.notFound().build(); // HTTP 404 No Encontrado
    }
}
