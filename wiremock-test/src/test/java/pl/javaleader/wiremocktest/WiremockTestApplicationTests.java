package pl.javaleader.wiremocktest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import pl.javaleader.wiremocktest.configuration.ConfigProperties;

@SpringBootTest
@EnableConfigurationProperties(ConfigProperties.class)
class WiremockTestApplicationTests {

	@Test
	void contextLoads() {
	}

}
