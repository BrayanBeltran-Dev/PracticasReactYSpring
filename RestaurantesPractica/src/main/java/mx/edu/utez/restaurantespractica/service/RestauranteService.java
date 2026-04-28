package mx.edu.utez.restaurantespractica.service;

import mx.edu.utez.restaurantespractica.dto.RestauranteRequestDTO;
import mx.edu.utez.restaurantespractica.model.DetalleUbicacion;
import mx.edu.utez.restaurantespractica.model.Restaurante;
import mx.edu.utez.restaurantespractica.repository.DetalleRepository;
import mx.edu.utez.restaurantespractica.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    @Transactional
    public Restaurante registrar(RestauranteRequestDTO dto){
        DetalleUbicacion detalle = new DetalleUbicacion();
        detalle.setCalle(dto.getCalle());
        detalle.setCiudad(dto.getCiudad());
        detalle.setCodigoPostal(dto.getCodigoPostal());
        detalle.setCapacidadMesas(dto.getCapacidadMesas());

        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(dto.getNombre());
        restaurante.setTipoCocina(dto.getTipoCocina());
        restaurante.setTelefono(dto.getTelefono());
        restaurante.setAnioApertura(dto.getAnioApertura());

        detalle.setRestaurante(restaurante);
        restaurante.setDetalle(detalle);
        return restauranteRepository.save(restaurante);
    }

    @Transactional(readOnly = true)
    public Restaurante BuscarPorId(Long id){
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
    }
}
