package service.impl;

import service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    public double add(double numberA, double numberB) {
        return numberA + numberB;
    }

    public double subtract(double numberA, double numberB) {
        return numberA - numberB;
    }

    public double multiply(double numberA, double numberB) {
        return numberA * numberB;
    }

    public double divide(double numberA, double numberB) {
        return numberA / numberB;
    }
}
