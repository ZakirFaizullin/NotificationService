package org.example.notificationservice.sevices;

import lombok.AllArgsConstructor;
import org.example.notificationservice.model.StringValue;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {

    private JavaMailSender javaMailSender;

    public void sendNotification(List<StringValue> values) {
        for (var value : values) {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(value.email());
            if (value.operation().equals("created")) {
                email.setSubject("Ваш аккаунт создан.");
                email.setText("Здравствуйте! Ваш аккаунт на сайте был успешно создан.");
            }
            else if (value.operation().equals("deleted")) {
                email.setSubject("Ваш аккаунт удален.");
                email.setText("Здравствуйте! Ваш аккаунт был удалён.");
            }
            javaMailSender.send(email);
        }
    }

}
