package pl.javaleader.injcectionspringapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.javaleader.injcectionspringapp.service.Printer;

@RestController
public class AppInjectionManagerBySetterRestController {

    private Printer printer;

    @Qualifier("printerImpl")
    @Autowired
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @GetMapping(path="/printerInjectedBySetter")
    @ResponseBody
    public String getPrinterInjectedBySetter() {
        return printer.print("printer injected by setter");
    }
}
