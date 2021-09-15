package ar.com.undec.escuela.controller;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Curso;
import ar.com.undec.escuela.model.Tipopersona;
import ar.com.undec.escuela.service.TipoPersonaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipopersona")
@Tag(name = "Tipos de Persona")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @GetMapping("/todos")
    public ResponseEntity<Response> list(){
        Response response = tipoPersonaService.findall();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Response> get(@PathVariable String id){
        Response response = tipoPersonaService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Response> put(@RequestBody Tipopersona actualizarTipo){
        Response response = tipoPersonaService.update(actualizarTipo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody Tipopersona guardarTipo) {
        Response response = tipoPersonaService.save(guardarTipo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = tipoPersonaService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
