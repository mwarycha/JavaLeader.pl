package pl.javaleader.wiremocktest.integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.javaleader.wiremocktest.configuration.ConfigProperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Import(ConfigProperties.class)
@EnableConfigurationProperties(value = ConfigProperties.class)
@ContextConfiguration(classes = ConfigProperties.class)
@TestPropertySource("classpath:application.properties")
@ExtendWith(SpringExtension.class)
public class WiremockTests {
 
    RestTemplate restTemplate;
    ResponseEntity response;
    WireMockServer wireMockServer;

    @Autowired
    private ConfigProperties configProperties;

@BeforeEach
public void setup(){
    restTemplate   = new RestTemplate();
    response       = null;
    wireMockServer = new WireMockServer(wireMockConfig().port(configProperties.getPort()));
    wireMockServer.start();
}

    @Test
    public void givenWireMockAdminEndpoint_whenGetWithoutParams_thenVerifyRequest() {

        RestTemplate restTemplate = new RestTemplate();

        response = restTemplate.getForEntity("http://localhost:8888/__admin", String.class);

        assertThat("Verify Response Body", response.getBody().toString().contains("mappings"));
        assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));
    }


    @Test
    public void testResourceApi() {
        System.out.println(configProperties.getHost());
        wireMockServer.stubFor(get(urlEqualTo("/api/resource"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", TEXT_PLAIN_VALUE)
                        .withBody("test resource")));

        response = restTemplate.getForEntity(createHttpLink(), String.class);

        assertThat("Verify Response Body", response.getBody().toString().contains("test resource"));
        assertThat("Verify Status Code", response.getStatusCode().equals(HttpStatus.OK));

        wireMockServer.stop();
    }

    private String createHttpLink() {
        StringBuilder httpLink = new StringBuilder();
        httpLink.append("http://");
        httpLink.append(configProperties.getHost());
        httpLink.append(":");
        httpLink.append(configProperties.getPort());
        httpLink.append("/api/resource");
        return httpLink.toString();
    }
}