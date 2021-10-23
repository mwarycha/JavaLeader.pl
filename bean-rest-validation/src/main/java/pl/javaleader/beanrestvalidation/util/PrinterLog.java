package pl.javaleader.beanrestvalidation.util;

import org.springframework.stereotype.Component;

@Component
public class PrinterLog {

    public String printError(String error) {
        return "[ERROR] " + error;
    }

    public String printSuccess(String success) {
        return "[SUCCESS] " + success;
    }
}
