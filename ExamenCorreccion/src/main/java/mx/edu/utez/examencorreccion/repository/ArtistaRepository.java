package mx.edu.utez.examencorreccion.repository;

import mx.edu.utez.examencorreccion.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
