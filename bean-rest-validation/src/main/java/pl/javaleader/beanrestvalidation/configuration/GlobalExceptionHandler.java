package pl.javaleader.beanrestvalidation.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        errorResponse.put("status", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
