package pl.javaleader.customproperties.controller;

import pl.javaleader.customproperties.configuration.AppProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApp {

    AppProperties appProperties;

    public RestControllerApp(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/appName")
    public String getAppNameFromProperties() {
        return appProperties.getAppName();
    }

    @GetMapping("/appPort")
    public int getAppPortFromProperties() {
        return appProperties.getAppConfig().getAppPort();
    }
}
