package com.example.notifications_service.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message) {
        System.out.println("Enviando notificación: " + message);
        // aca va la lógica real para enviar un correo electrónico,
        // una notificación push o un SMS al usuario.
    }
}