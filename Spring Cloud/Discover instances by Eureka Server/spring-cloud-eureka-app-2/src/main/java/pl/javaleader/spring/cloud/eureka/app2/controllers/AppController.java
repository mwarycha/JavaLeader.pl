package pl.javaleader.spring.cloud.eureka.app2.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @RequestMapping(value="/process", method = RequestMethod.GET)
    public @ResponseBody String  showLoginPage(ModelMap model){
        return "Processing aap2 on port 8095";
    }
}