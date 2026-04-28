package mx.edu.utez.restaurantespractica.repository;

import mx.edu.utez.restaurantespractica.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
