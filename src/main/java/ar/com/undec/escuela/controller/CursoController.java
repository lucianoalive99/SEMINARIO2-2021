package ar.com.undec.escuela.controller;

import ar.com.undec.escuela.dto.Response;
import ar.com.undec.escuela.model.Curso;
import ar.com.undec.escuela.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;



    @GetMapping("/todos")
    public ResponseEntity<Response> list(){
        Response response = cursoService.findall();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Response> get(@PathVariable String id){
        Response response = cursoService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Response> put(@RequestBody Curso actualizar){
        Response response = cursoService.update(actualizar);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody Curso curso) {
        Response response = cursoService.save(curso);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = cursoService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
