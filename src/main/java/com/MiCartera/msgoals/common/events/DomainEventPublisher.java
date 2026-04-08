package com.MiCartera.msgoals.common.events;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DomainEventPublisher {

  private final RabbitTemplate rabbitTemplate;

  public void publish(String routingKey, Object payload) {
    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, routingKey, payload);
  }
}