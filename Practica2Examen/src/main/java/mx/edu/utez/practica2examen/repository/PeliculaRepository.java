package mx.edu.utez.practica2examen.repository;

import mx.edu.utez.practica2examen.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
