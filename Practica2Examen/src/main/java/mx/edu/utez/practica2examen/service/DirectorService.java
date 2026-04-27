package mx.edu.utez.practica2examen.service;

import mx.edu.utez.practica2examen.dto.DirectorRequestDTO;
import mx.edu.utez.practica2examen.model.Director;
import mx.edu.utez.practica2examen.model.Pelicula;
import mx.edu.utez.practica2examen.repository.DirectorRepository;
import mx.edu.utez.practica2examen.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Transactional
    public Director registar(DirectorRequestDTO dto){
        Director director = new Director();
        director.setNombre(dto.getNombre());
        director.setNacionalidad(dto.getNacionalidad());

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setAnio(dto.getAnio());
        pelicula.setGenero(dto.getGenero());
        pelicula.setDirector(director);

        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula);
        director.setPeliculas(peliculas);

        return directorRepository.save(director);
    }
    @Transactional(readOnly = true)
    public List<Director> listar(){
        return directorRepository.findAll();
    }
}
