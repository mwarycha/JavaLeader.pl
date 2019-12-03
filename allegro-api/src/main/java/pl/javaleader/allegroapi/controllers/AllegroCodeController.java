package pl.javaleader.allegroapi.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.javaleader.AllegroEnum;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AllegroCodeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/protected")
    String showJavaLeaderMsg(Principal principal){
        return "[user] " +  principal.getName() + " JavaLeader.pl!";
    }

    @RequestMapping(value = "/sale/categories/{categoryId}/product/parameters")
    public String getSaleCategoriesProductParameters(@PathVariable String categoryId, @RequestHeader("Authorization") String bearer) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("ACCEPT", AllegroEnum.ACCEPT.acceptHeader);
        headers.add("Authorization", bearer );

        HttpEntity <String> entity = new HttpEntity(headers);
        return restTemplate.exchange("https://api.allegro.pl/sale/categories/" + categoryId + "/product-parameters",
                HttpMethod.GET, entity, String.class).getBody();
    }
}
