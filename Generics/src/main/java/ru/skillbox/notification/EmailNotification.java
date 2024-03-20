package ru.skillbox.notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class EmailNotification implements Notification {
    private String subject;
    private List<String> receiver;

    public String formattedMessage(String message) {
        return "<p>" + message + "</p>";
    }
}

