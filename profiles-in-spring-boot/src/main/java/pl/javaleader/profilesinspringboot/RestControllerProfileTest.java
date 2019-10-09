package pl.javaleader.profilesinspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerProfileTest {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/app")
    public String getInjectedValue() {
        return appName;
    }
}
