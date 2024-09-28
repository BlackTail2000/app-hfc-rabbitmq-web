package com.example.app_hfc_rabbitmq_web.controller;

import com.example.app_hfc_rabbitmq_web.enqueue.producer.ProjNotifProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProjNotifController {
    private  final ProjNotifProducer projNotifProducer;

    @GetMapping("/enviar")
    public String enviandoMensaje(@RequestParam String mensaje){
        projNotifProducer.enviarMensaje(mensaje);
        return "Notificación de proyecto enviada a RabbitMQ : " + mensaje;
    }
}
