package ru.skillbox.notification_sender;
import ru.skillbox.notification.EmailNotification;
import java.util.List;

public class EmailNotofocationSender implements NotificationSender<EmailNotification> {

    @Override
    public void send(List<EmailNotification> notifications) {
        for (EmailNotification notification : notifications) {
            send(notification);
        }
    }

    @Override
    public void send(EmailNotification notification) {
        System.out.println("subject: " + notification.getSubject());
        System.out.println("receivers: " + String.join(", ", notification.getReceiver()));
        System.out.println("message: " + notification.formattedMessage("Спасибо за регистрацию на сервисе!"));
    }
}
