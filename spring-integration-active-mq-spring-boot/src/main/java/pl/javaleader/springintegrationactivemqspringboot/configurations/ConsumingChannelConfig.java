package pl.javaleader.springintegrationactivemqspringboot.configurations;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;

import javax.jms.ConnectionFactory;

@Configuration
public class ConsumingChannelConfig {

  @Bean
  public DirectChannel consumingChannel() {
    return new DirectChannel();
  }

  @Bean
  public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint(ConnectionFactory connectionFactory) {
    System.out.println(connectionFactory.getClass());
    JmsMessageDrivenEndpoint endpoint = new JmsMessageDrivenEndpoint(simpleMessageListenerContainer(connectionFactory), channelPublishingJmsMessageListener());
    endpoint.setOutputChannel(consumingChannel());
    return endpoint;
  }

  @Bean
  public SimpleMessageListenerContainer simpleMessageListenerContainer(
      ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container =
        new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setDestinationName("javaLeaderQueue");
    return container;
  }

  @Bean
  public ChannelPublishingJmsMessageListener channelPublishingJmsMessageListener() {
    return new ChannelPublishingJmsMessageListener();
  }

  @Bean
  @ServiceActivator(inputChannel = "consumingChannel")
  public JavaLeaderMessageHandler javaLeaderMessageHandler() {
    return new JavaLeaderMessageHandler();
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    return new ActiveMQConnectionFactory();
  }
}