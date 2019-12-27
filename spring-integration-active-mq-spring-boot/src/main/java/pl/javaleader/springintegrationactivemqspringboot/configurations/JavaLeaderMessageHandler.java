package pl.javaleader.springintegrationactivemqspringboot.configurations;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import pl.javaleader.springintegrationactivemqspringboot.JavaLeaderService;

import org.springframework.beans.factory.annotation.Autowired;

public class JavaLeaderMessageHandler implements MessageHandler {

  @Autowired
  JavaLeaderService javaLeaderService;

  @Override
  public void handleMessage(Message<?> message) {
    javaLeaderService.printMsg(message.getPayload().toString());
  }
}