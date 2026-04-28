package mx.edu.utez.restaurantespractica.controller;

import jakarta.validation.Valid;
import mx.edu.utez.restaurantespractica.dto.RestauranteRequestDTO;
import mx.edu.utez.restaurantespractica.dto.RestauranteResponseDTO;
import mx.edu.utez.restaurantespractica.model.Restaurante;
import mx.edu.utez.restaurantespractica.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteResponseDTO> registrar(@Valid@RequestBody RestauranteRequestDTO dto){
        Restaurante restaurante = restauranteService.registrar(dto);
        RestauranteResponseDTO response = new RestauranteResponseDTO();
        response.setId(restaurante.getId());
        response.setNombre(dto.getNombre());
        response.setTipoCocina(restaurante.getTipoCocina());
        response.setTelefono(dto.getTelefono());
        response.setAnioApertura(restaurante.getAnioApertura());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponseDTO> buscarPorId(@PathVariable Long id){
        Restaurante restaurante = restauranteService.BuscarPorId(id);
            RestauranteResponseDTO response = new RestauranteResponseDTO();
            response.setId(restaurante.getId());
            response.setNombre(restaurante.getNombre());
            response.setTipoCocina(restaurante.getTipoCocina());
            response.setTelefono(restaurante.getTelefono());
            response.setAnioApertura(restaurante.getAnioApertura());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
