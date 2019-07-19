package pl.javaleader.spring.cloud.eureka.app.consumer.controllers;

import java.io.IOException;
import org.springframework.web.client.RestClientException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.javaleader.spring.cloud.eureka.app.consumer.service.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @Autowired
    private Client client;

    @RequestMapping(value="/process", method = RequestMethod.GET)
    public @ResponseBody String  showLoginPage(ModelMap model) throws RestClientException, IOException{
        return client.getEmployee("/process");
    }
}