package pl.javaleader.service;

import java.util.Date;
import org.json.JSONArray;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Service
public class ClientServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callClientServiceAndGetData_Fallback")
    public String callClientServiceAndGetData(String clientId) {

        // the exchange method executes the HTTP method against the specified URI template, passing in the parameters for replacement.
        String response = restTemplate
                .exchange("http://localhost:8098/getClientDetails/{clientId}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, clientId).getBody();

        return "NORMAL FLOW !!! - Client Details " + response + " - " + new Date();

    }

    @SuppressWarnings("unused")
    private String callClientServiceAndGetData_Fallback(String clientId) {
        return "CIRCUIT BREAKER ENABLED!!!" + clientId + new Date();
    }

    private void printJsonResponseFromJsonArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.getJSONObject(i).getString("name"));
            System.out.println(jsonArray.getJSONObject(i).getString("surname"));
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}