package mx.edu.utez.practica3examen.service;

import mx.edu.utez.practica3examen.dto.VideojuegoRequestDTO;
import mx.edu.utez.practica3examen.model.DetalleDesarrollo;
import mx.edu.utez.practica3examen.model.Videojuego;
import mx.edu.utez.practica3examen.repository.DetalleRepository;
import mx.edu.utez.practica3examen.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    @Transactional
    public Videojuego registrar(VideojuegoRequestDTO dto){
        Videojuego videojuego = new Videojuego();
        videojuego.setTitulo(dto.getTitulo());
        videojuego.setGenero(dto.getGenero());
        videojuego.setPlataforma( dto.getPlataforma());
        videojuego.setAnioLanzamiento(dto.getAnioLanzamiento());

        DetalleDesarrollo detalle = new DetalleDesarrollo();
        detalle.setEstudio(dto.getEstudio());
        detalle.setDuracioHoras(dto.getDuracionHoras());
        detalle.setJugadoresMaximos(dto.getJugadoresMaximos());
        detalle.setIdioma( dto.getIdioma());

        detalle.setVideojuego(videojuego);
        videojuego.setDetalle(detalle);
        return videojuegoRepository.save(videojuego);

    }

    @Transactional(readOnly = true)
    public List<Videojuego>  listar(){
        return videojuegoRepository.findAll();
    }

    @Transactional
    public Videojuego actualizar(Long id, VideojuegoRequestDTO dto) {
        // 1. Buscamos el videojuego por su ID
        Videojuego videojuego = videojuegoRepository.findById(id).orElse(null);

        if (videojuego != null) {
            // 2. Actualizamos los datos principales
            videojuego.setTitulo(dto.getTitulo());
            videojuego.setGenero(dto.getGenero());
            videojuego.setPlataforma(dto.getPlataforma());
            videojuego.setAnioLanzamiento(dto.getAnioLanzamiento());

            // 3. Obtenemos el detalle asociado y lo actualizamos
            DetalleDesarrollo detalle = videojuego.getDetalle();
            if (detalle != null) {
                detalle.setEstudio(dto.getEstudio());
                detalle.setDuracioHoras(dto.getDuracionHoras()); // Nota: usa el nombre exacto de tu método set
                detalle.setJugadoresMaximos(dto.getJugadoresMaximos());
                detalle.setIdioma(dto.getIdioma());
            }

            // 4. Guardamos los cambios (Cascada guardará el detalle automáticamente si está configurado)
            return videojuegoRepository.save(videojuego);
        }
        return null; // Retornamos null si no se encontró el ID
    }

    @Transactional
    public boolean eliminar(Long id) {
        if (videojuegoRepository.existsById(id)) {
            videojuegoRepository.deleteById(id);
            return true; // Se eliminó correctamente
        }
        return false; // No existía el ID
    }
}
