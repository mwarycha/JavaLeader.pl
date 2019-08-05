package pl.javaleader.springbootexceptionhandler.exceptions;

public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
