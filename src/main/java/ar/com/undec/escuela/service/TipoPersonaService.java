package ar.com.undec.escuela.service;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Curso;
import ar.com.undec.escuela.model.Tipopersona;
import ar.com.undec.escuela.repository.TipoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class TipoPersonaService {

    @Autowired
    TipoPersonaRepository tipoPersonaRepository;

    public Response findall(){
        Response response = new Response();
        try {
            List<Tipopersona> tipopersonaList = tipoPersonaRepository.findAll();
            response.setData(tipopersonaList);
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
            Tipopersona tipopersona = tipoPersonaRepository.findById(Integer.parseInt(id)).get();
            response.setMessage("Tipo de persona encontrado: ");
            response.setData(tipopersona);
        } catch(Exception e){
            LOGGER.error("No se encontro el tipo de persona ingresado.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(Tipopersona nuevo) {
        Response response = new Response();
        try {
            tipoPersonaRepository.save(nuevo);
            response.setMessage("Tipo de persona actualizado.");
        } catch(Exception e){
            LOGGER.error("No se pudo actualizar el tipo de persona.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            tipoPersonaRepository.deleteById(Integer.parseInt(id));
            response.setMessage("Tipo de persona borrado");
        } catch(Exception e){
            LOGGER.error("No se pudo borrar el Tipo de persona.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(Tipopersona nuevo) {
        Response response = new Response();
        try {
            tipoPersonaRepository.save(nuevo);
            response.setMessage("Tipo de persona guardado.");
        } catch(Exception e){
            LOGGER.error("No se pudo guardar el Tipo de persona.");
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}
