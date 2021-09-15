package ar.com.undec.escuela.controller;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Materia;
import ar.com.undec.escuela.service.MateriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
@Tag(name = "Materias")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @GetMapping("/todos")
    public ResponseEntity<Response> list(){
        Response response =materiaService.findall();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Response> get(@PathVariable String id){
        Response response = materiaService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Response> put(@RequestBody Materia actualizar){
        Response response = materiaService.update(actualizar);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody Materia curso) {
        Response response = materiaService.save(curso);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = materiaService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
