package pl.javaleader.restapi.configurations;

import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:9872/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("javaleader.pl | swagger api")
                .description("Swagger example REST API")
                .termsOfServiceUrl("https://kontakt@javaleader.pl")
                .contact("kontakt@javaleader.pl").license("License API")
                .licenseUrl("https://javaleader.pl/2019/06/18/swagger-ui-prosty-sposob-na-wizualizacje-api/").version("1.0").build();
    }
}