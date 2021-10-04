package pl.javaleader.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnviromentInfo {

    @Value("#{systemProperties['java.home']}")
    public String JAVA_HOME;
}

