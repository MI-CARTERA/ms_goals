package com.MiCartera.msgoals.common.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleEventListener {

  @RabbitListener(queues = RabbitConfig.QUEUE)
  public void onMessage(Object event) {
    log.info("Event recibido: {}", event);
  }
}