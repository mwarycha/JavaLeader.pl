package pl.junit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.IncludeTags;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
@IncludeTags("production")
public class MyTests {

    @Test
    @Tag("development")
    public void multiplyDevelopmentTest() {
        System.out.println("run test 1");
        assertEquals(6, 6);
    }

    @Test
    @Tag("production")
    public void multiplyProductionTest() {
        System.out.println("run test 2");
        assertEquals(6, 6);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MyTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}