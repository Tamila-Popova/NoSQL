package ru.skillbox.notification;
import com.sun.nio.sctp.Association;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class PushNotification implements Notification {
    private String title;
    private List<String> receiver;

    public String formattedMessage(String message) {
        return message;
    }

}
