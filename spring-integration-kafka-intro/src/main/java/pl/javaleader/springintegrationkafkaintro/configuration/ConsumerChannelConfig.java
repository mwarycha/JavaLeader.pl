package pl.javaleader.springintegrationkafkaintro.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.kafka.core.*;
import org.springframework.messaging.PollableChannel;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerChannelConfig {
 
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.topic}")
    private String springIntegrationKafkaTopic;

    @Bean
    public PollableChannel consumerChannel() {
        return new QueueChannel();
    }

//    @Bean
//    public KafkaMessageDrivenChannelAdapter kafkaMessageDrivenChannelAdapter() {
//        KafkaMessageDrivenChannelAdapter kafkaMessageDrivenChannelAdapter = new KafkaMessageDrivenChannelAdapter(
//                kafkaListenerContainer());
//        kafkaMessageDrivenChannelAdapter.setOutputChannel(consumerChannel());
//
//        return kafkaMessageDrivenChannelAdapter;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Bean
//    public ConcurrentMessageListenerContainer kafkaListenerContainer() {
//        ContainerProperties containerProps = new ContainerProperties(springIntegrationKafkaTopic);
//        containerProps.setGroupId("test");
//        return (ConcurrentMessageListenerContainer) new ConcurrentMessageListenerContainer(
//                consumerFactory(), containerProps);
//    }

    @Bean
    public ConsumerFactory consumerFactory() {
        return new DefaultKafkaConsumerFactory(consumerConfigs());
    }

    @Bean
    public Map consumerConfigs() {
        Map properties = new HashMap();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return properties;
    }
}