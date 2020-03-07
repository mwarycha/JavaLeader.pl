package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.javaleader.ws.Calculator;

public class Demo {

    public static void main(String args[]) {

        //https://manios.org/2018/04/03/java-soap-service-client-debug-http-message

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        ApplicationContext context = new ClassPathXmlApplicationContext("/client-beans.xml");

        Calculator soap = (Calculator) context.getBean("calcClient");

        System.out.println(soap.addidtion(2,3));

    }
}