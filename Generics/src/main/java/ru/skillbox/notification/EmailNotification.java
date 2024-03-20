package ru.skillbox.notification;
import java.util.List;

public class EmailNotification implements Notification {
    private String subject;
    private List<String> receiver;

    public EmailNotification(String subject, List<String> receiver) {
        this.subject = subject;
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getReceiver() {
        return receiver;
    }

    public String formattedMessage(String message) {
        return "<p>" + message + "</p>";
    }
}

