package ar.com.undec.escuela.service;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Curso;
import ar.com.undec.escuela.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Response findall(){
        Response response = new Response();
        try {
            List<Curso> cursoList = cursoRepository.findAll();
            response.setData(cursoList);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findById(String id){
        Response response = new Response();
        try {
            Curso curso = cursoRepository.findById(Integer.parseInt(id)).get();
            response.setMessage("Curso encontrado: ");
            response.setData(curso);
        } catch(Exception e){
            LOGGER.error("No se encontro el curso ingresado.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(Curso nuevo) {
        Response response = new Response();
        try {
            cursoRepository.save(nuevo);
            response.setMessage("Curso actualizado.");
        } catch(Exception e){
            LOGGER.error("No se pudo actualizar el curso.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            cursoRepository.deleteById(Integer.parseInt(id));
            response.setMessage("Curso borrado");
        } catch(Exception e){
            LOGGER.error("No se pudo borrar el curso ingresado.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(Curso nuevo) {
        Response response = new Response();
        try {
            cursoRepository.save(nuevo);
            response.setMessage("Curso guardado.");
        } catch(Exception e){
            LOGGER.error("No se pudo guardar el curso.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}
