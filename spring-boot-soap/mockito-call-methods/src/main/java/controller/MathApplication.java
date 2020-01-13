package controller;

import service.CalculatorService;

public class MathApplication {

   private CalculatorService calcService;

   public void setCalculatorService(CalculatorService calcService){
      this.calcService = calcService;
   }
   
   public double add(double numberA, double numberB){
      return calcService.add(numberA, numberB);
   }
   
   public double subtract(double numberA, double numberB){
      return calcService.subtract(numberA, numberB);
   }
   
   public double multiply(double numberA, double numberB){
      return calcService.multiply(numberA, numberB);
   }
   
   public double divide(double numberA, double numberB){
      return calcService.divide(numberA, numberB);
   }
}