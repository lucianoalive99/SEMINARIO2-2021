package ar.com.undec.escuela.repository;

import ar.com.undec.escuela.model.Tipopersona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPersonaRepository extends JpaRepository<Tipopersona, Integer> {
}
