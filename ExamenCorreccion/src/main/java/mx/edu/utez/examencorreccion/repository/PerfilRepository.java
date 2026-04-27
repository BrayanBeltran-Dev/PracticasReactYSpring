package mx.edu.utez.examencorreccion.repository;

import mx.edu.utez.examencorreccion.model.PerfilDiscografico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilDiscografico,Long> {
}
