package pl.javaleader.springsecuritybasicauthentication.controllers;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data")
public class RestApiController {

    @GetMapping(path="/json", produces = "application/json")
    public String getJsonData() {

        String jsonString = new JSONObject()
                .put("json", "json value").toString();

        return jsonString;
    }

}
