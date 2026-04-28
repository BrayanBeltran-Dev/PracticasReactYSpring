package mx.edu.utez.practica3examen.repository;

import mx.edu.utez.practica3examen.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
