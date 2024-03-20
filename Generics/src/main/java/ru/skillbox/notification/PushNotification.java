package ru.skillbox.notification;
import com.sun.nio.sctp.Association;
import java.util.List;

public class PushNotification implements Notification {
    private String title;
    private List<String> receiver;

    public PushNotification(String title, List<String> receiver) {
        this.title = title;
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getReceiver() {
        return receiver;
    }

    public String formattedMessage(String message) {
        return message;
    }

}
