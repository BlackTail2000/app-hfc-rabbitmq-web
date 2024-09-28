package com.example.app_hfc_rabbitmq_web.enqueue.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjNotifConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "hfc_proj_notif_exchange";
    private static final String ROUTING_KEY = "hfc_proj_notif_routing";

    public void enviarMensaje(String mensaje) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, mensaje);
        log.info("Notificación de proyecto enviada: " + mensaje);
    }
}
