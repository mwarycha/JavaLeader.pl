package pl.javaleader.injcectionspringapp.controllers;

import pl.javaleader.injcectionspringapp.service.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInjectionManagerByFieldRestController {

    @Autowired
    private Printer printer;

    @GetMapping(path="/printerInjectedByField")
    @ResponseBody
    public String getPrinterInjectedByField() {
        return printer.print("printer injected by field");
    }
}
