package pl.javaleader.rabbitmq.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "${queue.name}")
    private void reader(String text){
        System.out.println("email received from pl.javaleader queue " + text);
    }
}
