package pl.javaleader.injcectionspringapp.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("printerPrototypeImpl")
@Scope("prototype")
public class PrinterPrototypeImpl implements Printer {
    @Override
    public String print(String message) {
        return "[log] " + message;
    }
}