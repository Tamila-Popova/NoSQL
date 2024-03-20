package ru.skillbox;
import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotofocationSender;
import ru.skillbox.notification_sender.PushNotoficationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailNotofocationSender emailSender = new EmailNotofocationSender();
        List<EmailNotification> emailNotifications = new ArrayList<>();
        System.out.println("\r\n" + "EMAIL");
        EmailNotification notification = new EmailNotification("Успешная регистрация!", List.of("masha@mail.ru", "ivan@mail.ru", "nastya@mail.ru"));
        emailNotifications.add(notification);
        emailSender.send(emailNotifications);

        SmsNotificationSender smsSender = new SmsNotificationSender();
        List<SmsNotification> smsNotifications = new ArrayList<>();
        System.out.println("\r\n" + "SMS");
        SmsNotification notification1 = new SmsNotification(List.of("+78005553535"));
        smsNotifications.add(notification1);
        smsSender.send(smsNotifications);

        PushNotoficationSender pushSender = new PushNotoficationSender();
        List<PushNotification> pushNotifications = new ArrayList<>();
        System.out.println("\r\n" + "PUSH");
        PushNotification notification2 = new PushNotification("Успешная регистрация!", List.of("o.ivanov"));
        pushNotifications.add(notification2);
        pushSender.send(pushNotifications);
    }
}
