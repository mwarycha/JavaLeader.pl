package pl.javaleader.ConsumerDrivenContractProducer;

import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.javaleader.ConsumerDrivenContractProducer.controllers.CalculatorController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerDrivenContractProducerApplication.class)
public abstract class BaseClass {

    @Autowired
    CalculatorController calculatorController;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(calculatorController);
    }

}