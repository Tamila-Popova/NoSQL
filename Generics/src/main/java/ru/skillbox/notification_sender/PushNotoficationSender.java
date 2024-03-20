package ru.skillbox.notification_sender;
import ru.skillbox.notification.PushNotification;
import java.util.List;

public class PushNotoficationSender implements NotificationSender<PushNotification> {

    @Override
    public void send(List<PushNotification> notifications) {
        for (PushNotification notification : notifications) {
            send(notification);
        }
    }

    @Override
    public void send(PushNotification notification) {
        System.out.println("title: " + notification.getTitle());
        System.out.println("receivers: " + notification.getReceiver());
        System.out.println("message: " + notification.formattedMessage("\ud83d\udc4b Спасибо за регистрацию на сервисе!"));
    }
}
