package pl.javaleader.kafkaquickstart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "34")
    public void consume(String message){
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
    }

}