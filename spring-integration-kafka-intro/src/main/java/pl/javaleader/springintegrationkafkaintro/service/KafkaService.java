package pl.javaleader.springintegrationkafkaintro.service;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.dsl.kafka.Kafka;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import pl.javaleader.springintegrationkafkaintro.model.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.integration.dsl.support.Transformers.fromJson;

@Service
public class KafkaService {

    @Autowired
    ConfigurableApplicationContext context;

    @Autowired
    private IntegrationFlowContext flowContext;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    PollableChannel consumerChannel;

    public void createOnKafkaSampleItems(int itemNumber) {

        System.out.println("[START] create on kafka sample message");

        MessageChannel producerChannel = context.getBean("producerChannel", MessageChannel.class);

        List<Item> items = new ArrayList();

        items.add(new Item("item" + itemNumber));

        items.forEach(item -> {
            producerChannel.send(new GenericMessage(item, Collections.singletonMap(KafkaHeaders.TOPIC, "items")));
        });

        System.out.println("[STOP] create on kafka sample message");
    }

    public void addAnotherListenerForTopics(String... topics) {
        Map consumerProperties = kafkaProperties.buildConsumerProperties();
        consumerProperties.put("group.id", "dummy");

        IntegrationFlowBuilder flow = IntegrationFlows
                .from(Kafka.messageDrivenChannelAdapter(new DefaultKafkaConsumerFactory(consumerProperties), topics))

                .publishSubscribeChannel(subscription ->
                        subscription

                                .subscribe(subflow -> subflow
                                        .transform(fromJson(Item.class, new Jackson2JsonObjectMapper()))
                                        .transform(x -> Item.class.cast(x).getName() + " [flow1]")
                                        .channel("consumerChannel"))

                                .subscribe(subflow -> subflow
                                        .transform(fromJson(Item.class, new Jackson2JsonObjectMapper()))
                                        .transform(x -> Item.class.cast(x).getName() + " [flow2]")
                                        .channel("consumerChannel"))

                                .subscribe(subflow -> subflow
                                        .transform(fromJson(Item.class, new Jackson2JsonObjectMapper()))
                                        .transform(x -> Item.class.cast(x).getName() + " [flow3]")
                                        .channel("consumerChannel")));

        this.flowContext.registration(flow.get()).register();
    }

    public void consumerMessage() {

        addAnotherListenerForTopics("items");

        PollableChannel consumerChannel = context.getBean("consumerChannel", PollableChannel.class);

        Message<?> received = consumerChannel.receive();

        while (received != null) {
            System.out.println("Received " + received.getPayload());
            received = consumerChannel.receive();
        }
    }
}
