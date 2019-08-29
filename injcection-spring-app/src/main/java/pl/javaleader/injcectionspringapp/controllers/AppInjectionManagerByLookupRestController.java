package pl.javaleader.injcectionspringapp.controllers;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.javaleader.injcectionspringapp.service.Printer;

@RestController
public class AppInjectionManagerByLookupRestController {

    @Lookup("printerPrototypeImpl")
    public Printer getPrinter() {
        return null;
    }

    @GetMapping(path = "/printerInjectedByLookup")
    @ResponseBody
    public String getPrinterInjectedByField() {
        return getPrinter().print("printer injected by field") + " " + (getPrinter() == getPrinter());

    }
}
