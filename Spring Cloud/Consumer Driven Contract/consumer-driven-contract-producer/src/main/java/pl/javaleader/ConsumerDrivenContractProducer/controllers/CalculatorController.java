package pl.javaleader.ConsumerDrivenContractProducer.controllers;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @RequestMapping(value = "/addition/{number1}/{number2}", method = {RequestMethod.GET}, produces = "application/json")
    CalculatorModel addition(@PathVariable int number1, @PathVariable int number2){
        return CalculatorModel.builder()
                .result(number1 + number2)
                .operation("addition")
                .build();
    }

    @RequestMapping(value ="/subtract/{number1}/{number2}", method = {RequestMethod.GET},produces = "application/json")
    CalculatorModel subtract(@PathVariable int number1, @PathVariable int number2){
        return CalculatorModel.builder()
                .result(number1 - number2)
                .operation("subtract")
                .build();
    }

    @RequestMapping(value ="/multiply/{number1}/{number2}", method = {RequestMethod.GET},produces = "application/json")
    CalculatorModel multiply(@PathVariable int number1, @PathVariable int number2){
        return CalculatorModel.builder()
                .result(number1 * number2)
                .operation("multiply")
                .build();
    }

    @RequestMapping(value ="/division/{number1}/{number2}", method = {RequestMethod.GET},produces = "application/json")
    CalculatorModel division(@PathVariable int number1, @PathVariable int number2){
        return CalculatorModel.builder()
                .result(number1 / number2)
                .operation("division")
                .build();
    }
}

@Builder
@Data
class CalculatorModel {
    private int    result;
    private String operation;
}
