package pl.javaleader.springintegrationkafkaintro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import pl.javaleader.springintegrationkafkaintro.service.KafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class SpringIntegrationKafkaIntroApplication implements CommandLineRunner {

	@Autowired
	KafkaService kafkaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationKafkaIntroApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Runnable createOnKafkaSampleItemsTask = () -> {
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 5; i++) {
				kafkaService.createOnKafkaSampleItems(i);
			}
		};

		new Thread(createOnKafkaSampleItemsTask).start();

		kafkaService.consumerMessage();
	}
}
