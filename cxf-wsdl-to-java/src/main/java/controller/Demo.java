package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.javaleader.ws.Calculator;
import pl.javaleader.ws.CalculatorImplService;

public class Demo {
    public static void main(String args[]) {
        CalculatorImplService service = new CalculatorImplService();
        Calculator calculatorProxy = service.getCalculatorImplPort();

        int resultAddition = calculatorProxy.addidtion(10, 20);
        System.out.println("Sum of 10+20 = " + resultAddition);

        int resultSubtraction = calculatorProxy.subtraction(10, 20);
        System.out.println("Subtraction of 10-20 = " + resultSubtraction);

        ApplicationContext context = new ClassPathXmlApplicationContext("/client-beans.xml");

        Calculator soap = (Calculator) context.getBean("calcClient");
        System.out.println(soap.addidtion(2,3));
        System.out.println(soap.subtraction(10,3));
    }
}