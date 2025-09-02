package org.example.notificationservice.consumer;

import lombok.AllArgsConstructor;
import org.example.notificationservice.model.StringValue;
import org.example.notificationservice.sevices.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class KafkaClient {

    private NotificationService notificationService;

    @KafkaListener(topics = "${application.kafka.topic}", containerFactory = "listenerContainerFactory")
    public void listen(List<StringValue> values) {
        notificationService.sendNotification(values);
    }

}
