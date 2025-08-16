package com.example.notifications_service.listener;

import com.example.notifications_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = "transaction-notification-queue")
    public void receiveMessage(String message) {
        System.out.println("Mensaje recibido de RabbitMQ: " + message);
        notificationService.sendNotification(message);
    }
}