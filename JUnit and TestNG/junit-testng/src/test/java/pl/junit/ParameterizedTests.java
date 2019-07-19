package pl.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ParameterizedTests {

    @Parameter(0)
    public int m1;
    @Parameter(1)
    public int m2;
    @Parameter(2)
    public int result;
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 2, 2, 4 }, { 5, 3, 15 }, { 6, 3, 18 } };
        return Arrays.asList(data);
    }

    @Test
    public void testMultiplyException() {
        ClassToBeTested classToBeTested = new ClassToBeTested();
        assertEquals("Result", result, classToBeTested.multiply(m1, m2));
    }
}