package com.example.app_hfc_rabbitmq_web.enqueue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("hfc_proj_notif_queue", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("hfc_proj_notif_exchange");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange)
                .with("hfc_proj_notif_routing");
    }
}
