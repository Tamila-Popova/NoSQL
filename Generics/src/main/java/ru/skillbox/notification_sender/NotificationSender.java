package ru.skillbox.notification_sender;
import ru.skillbox.notification.Notification;
import java.util.List;

public interface NotificationSender<T extends Notification> {
    void send(T notification);
    void send(List<T> notifications);
}
