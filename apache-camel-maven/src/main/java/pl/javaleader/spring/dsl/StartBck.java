package pl.javaleader.spring.dsl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartBck {

    private static final long  DURATION_MILIS = 10000;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("camel-context.xml");
        try {
            Thread.sleep(DURATION_MILIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }

}
