package pl.javaleader;

import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeeApi {

    final static String dumnyRestApi = "http://dummy.restapiexample.com/api/v1/employees";

    private static RestTemplate request = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApi.class, args);
    }

    @GetMapping("/getAllEmployees")
    public static String requestCodeData(){

        String result = request.getForObject(dumnyRestApi, String.class);
        System.out.print(dumnyRestApi);
        return (result);
    }
}
