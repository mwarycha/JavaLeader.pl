package pl.javaleader.springintegrationactivemqspringboot.configurations;

import org.apache.activemq.command.ActiveMQQueue;
import javax.jms.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {

    public static final String JAVA_LEADER_QUEUE = "javaLeaderQueue";

    @Bean
    public Queue javaLeaderQueue() {
        return new ActiveMQQueue(JAVA_LEADER_QUEUE);
    }
}