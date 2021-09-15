package ar.com.undec.escuela.controller;

import ar.com.undec.escuela.dto.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "ar.com.undec.escuela.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        Response response = new Response();
        response.setStatus(999);
        response.setMessage(ex.getStackTrace()[0].getClassName() + " - " + ex.getStackTrace()[0].getMethodName() + " - " + ex.getClass() + " - " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
