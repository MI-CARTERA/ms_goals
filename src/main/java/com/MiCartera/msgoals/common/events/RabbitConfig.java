package com.MiCartera.msgoals.common.events;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public static final String EXCHANGE = "mi_cartera_events";
  public static final String QUEUE = "ms_goals_queue";
  public static final String ROUTING_KEY_ALL = "#";

  @Bean
  public TopicExchange miCarteraExchange() {
    return new TopicExchange(EXCHANGE, true, false);
  }

  @Bean
  public Queue serviceQueue() {
    return QueueBuilder.durable(QUEUE).build();
  }

  @Bean
  public Binding bindAll(Queue serviceQueue, TopicExchange miCarteraExchange) {
    return BindingBuilder.bind(serviceQueue).to(miCarteraExchange).with(ROUTING_KEY_ALL);
  }
}