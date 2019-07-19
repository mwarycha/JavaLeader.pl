package pl.testng;

import org.testng.annotations.Test;

public class App {

    @Test
    public void AppMethod1() {
        System.out.println("App method - 1");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = { "AppMethod1" })
    public void AppMethod2() {
        System.out.println("App method - 2");
    }
}
