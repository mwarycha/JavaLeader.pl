package pl.javaleader.customproperties.configuration;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="app")
@Configuration
@Validated
public class AppProperties {

    AppConfig appConfig;

    @NotEmpty
    String appName;

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public static class AppConfig {

        int appPort = 8080;

        public int getAppPort() {
            return appPort;
        }

        public void setAppPort(int appPort) {
            this.appPort = appPort;
        }
    }
}
