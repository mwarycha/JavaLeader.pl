package pl.javaleader.springbootexceptionhandler.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DivisionByZeroHandleException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<Object> handleWebExeption(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e.getMessage(), HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
    }
}
