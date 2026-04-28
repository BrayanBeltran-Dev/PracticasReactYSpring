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
}
