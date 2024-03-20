package ru.skillbox.notification;
import java.util.List;

public class SmsNotification implements Notification {
    private List<String> receiver;

    public SmsNotification(List<String> receiver) {
        this.receiver = receiver;
    }

    public List<String> getReceiver() {
        return receiver;
    }

    public String formattedMessage(String message) {
        return message;
    }
}

