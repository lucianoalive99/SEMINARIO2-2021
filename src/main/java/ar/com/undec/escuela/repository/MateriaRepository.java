package ar.com.undec.escuela.repository;

import ar.com.undec.escuela.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia,Integer>{
}
