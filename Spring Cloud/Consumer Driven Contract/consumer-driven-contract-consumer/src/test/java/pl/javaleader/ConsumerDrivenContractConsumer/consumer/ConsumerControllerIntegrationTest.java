package pl.javaleader.ConsumerDrivenContractConsumer.consumer;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(workOffline = true, ids = { "pl.javaleader:Consumer-Driven-Contract-Producer"})
public class ConsumerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addition() throws Exception {

        // When
        ResultActions result = mockMvc.perform(get("/addition").contentType((MediaType.APPLICATION_JSON)));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("{\"result\":5,\"operation\":\"addition\"}"));
    }

    @Test
    public void subtract() throws Exception {

        // When
        ResultActions result = mockMvc.perform(get("/subtract").contentType((MediaType.APPLICATION_JSON)));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("{\"result\":-1,\"operation\":\"subtract\"}"));
    }

    @Test
    public void multiply() throws Exception {

        // When
        ResultActions result = mockMvc.perform(get("/multiply").contentType((MediaType.APPLICATION_JSON)));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("{\"result\":6,\"operation\":\"multiply\"}"));
    }

    @Test
    public void division() throws Exception {

        // When
        ResultActions result = mockMvc.perform(get("/division").contentType((MediaType.APPLICATION_JSON)));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("{\"result\":5,\"operation\":\"division\"}"));
    }

}