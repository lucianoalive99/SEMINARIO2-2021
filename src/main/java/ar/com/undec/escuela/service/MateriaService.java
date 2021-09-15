package ar.com.undec.escuela.service;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Materia;
import ar.com.undec.escuela.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;
    
    public Response findall(){
        Response response = new Response();
        try {
            List<Materia> MateriaList = materiaRepository.findAll();
            response.setData(MateriaList);
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
            Materia Materia = materiaRepository.findById(Integer.parseInt(id)).get();
            response.setMessage("Materia encontrada: ");
            response.setData(Materia);
        } catch(Exception e){
            LOGGER.error("No se encontro la materia ingresada.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(Materia nuevo) {
        Response response = new Response();
        try {
            materiaRepository.save(nuevo);
            response.setMessage("Materia actualizada.");
        } catch(Exception e){
            LOGGER.error("No se pudo actualizar la materia.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            materiaRepository.deleteById(Integer.parseInt(id));
            response.setMessage("Materia borrada");
        } catch(Exception e){
            LOGGER.error("No se pudo borrar la materia.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(Materia nuevo) {
        Response response = new Response();
        try {
            materiaRepository.save(nuevo);
            response.setMessage("Materia guardada.");
        } catch(Exception e){
            LOGGER.error("No se pudo guardar el Tipo de persona.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}
