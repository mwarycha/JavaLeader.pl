package pl.javaleader.springintegrationkafkaintro.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageHandler;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class ProducerChannelConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.topic}")
    private String springIntegrationKafkaTopic;

    @Bean
    public DirectChannel producerChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "producerChannel")
    public MessageHandler kafkaMessageHandler() {
        KafkaProducerMessageHandler handler = new KafkaProducerMessageHandler(kafkaTemplate());
        handler.setMessageKeyExpression(new LiteralExpression("kafka-integration"));
        return handler;
    }

    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }

    @Bean
    public ProducerFactory producerFactory() {
        return new DefaultKafkaProducerFactory(producerConfigs());
    }

    @Bean
    public Map producerConfigs() {
        Map properties = new HashMap();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        return properties;
    }
}
