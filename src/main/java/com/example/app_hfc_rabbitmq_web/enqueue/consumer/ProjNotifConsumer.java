package com.example.app_hfc_rabbitmq_web.enqueue.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjNotifConsumer {

    @RabbitListener(queues = "hfc_proj_notif_queue")
    public void consumeMensaje(String mensaje){
        log.info("Notificación de proyecto recibido: "+mensaje);
    }

}
