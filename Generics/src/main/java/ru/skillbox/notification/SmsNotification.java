package ru.skillbox.notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class SmsNotification implements Notification {
    private List<String> receiver;

    public String formattedMessage(String message) {
        return message;
    }
}

