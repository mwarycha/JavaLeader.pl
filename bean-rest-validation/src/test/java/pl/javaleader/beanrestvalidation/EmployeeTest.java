package pl.javaleader.beanrestvalidation;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.javaleader.beanrestvalidation.controller.EmployeeController;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.javaleader.beanrestvalidation.util.PrinterLog;
import org.mockito.Mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@Import(PrinterLog.class)
public class EmployeeTest {
 
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  PrinterLog printerLog;

  @Test
  void validEmployeeSuccessObject() throws Exception {

    Mockito.when(printerLog.printSuccess("employee is valid")).thenReturn("[OK] employee is valid");

    System.out.println(printerLog.printSuccess("employee is valid"));
    System.out.println(printerLog.printError("error"));

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/emp")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonSampleSuccessData());

    this.mockMvc.perform(builder)
            .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
            .andExpect(status().isOk());

  }

  private String jsonSampleSuccessData() {
    return "{\"name\":\"Java\",\"surname\":\"Leader\",\"salary\":1000,\"role\":\"DEV\"}";
  }

}