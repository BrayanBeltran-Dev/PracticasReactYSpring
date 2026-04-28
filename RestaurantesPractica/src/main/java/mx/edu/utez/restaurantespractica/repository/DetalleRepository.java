package mx.edu.utez.restaurantespractica.repository;

import mx.edu.utez.restaurantespractica.model.DetalleUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleUbicacion, Long> {
}
