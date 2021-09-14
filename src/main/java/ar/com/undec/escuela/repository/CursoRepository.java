package ar.com.undec.escuela.repository;

import ar.com.undec.escuela.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
