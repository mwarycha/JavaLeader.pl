package pl.javaleader.kafkaquickstart.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public NewTopic adviceTopic() {
        short replicationFactor = 1;
        int numPartitions       = 3;
        return new NewTopic("users", numPartitions, replicationFactor);
    }
}
