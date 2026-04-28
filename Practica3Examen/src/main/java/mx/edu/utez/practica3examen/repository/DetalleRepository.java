package mx.edu.utez.practica3examen.repository;

import mx.edu.utez.practica3examen.model.DetalleDesarrollo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleDesarrollo,Long> {
}
