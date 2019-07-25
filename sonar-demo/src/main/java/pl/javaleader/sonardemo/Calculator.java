package pl.javaleader.sonardemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    @GetMapping("/add/{a}/{b}")
    int add(@PathVariable int a, @PathVariable int b){
        return a+b;
    }

    @GetMapping("/subtract/{a}/{b}")
    int subtract(@PathVariable int a, @PathVariable int b){
        return a-b;
    }

    @GetMapping("/multiply/{a}/{b}")
    int multiply(@PathVariable int a, @PathVariable int b){
        return a*b;
    }


    @GetMapping("/divide/{a}/{b}")
    int divide(@PathVariable int a, @PathVariable int b){
        return a/b;
    }
}
