package pl.javaleader.rabbitmq.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/email-producer")
class Producer {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    RabbitTemplate queueSender;

    @GetMapping
    String sendToQueue(@RequestParam(value = "email") String message){
        queueSender.convertAndSend(queueName, message);
        return String.format("email %s has been sent to pl.javaleader queue!", message);
    }

}