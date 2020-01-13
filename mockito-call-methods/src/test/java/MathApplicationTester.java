import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import controller.MathApplication;
import org.junit.Assert;
import org.mockito.junit.MockitoJUnitRunner;
import service.CalculatorService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

   @InjectMocks
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){

      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

      verify(calcService, times(3)).add(10.0, 20.0);
   }
}