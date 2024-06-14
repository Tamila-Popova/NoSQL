import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class RedisTest {
    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis
    private static final int USERS = 20;
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(String mainUserId) {
        String log = String.format("- На главной странице показывавем пользователя " + mainUserId, DF.format(new Date()));
        out.println(log);
    }

    private static void setMainUserId(String userId) {
        log(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();
        int tenCount = 0;
        int randomCountForPayment = tenCount * 10 + (int) (10 * Math.random());
        int randomUserPayed = (int) (Math.random() * 20);
        redis.calculateUsersNumber(USERS);
        for (int i = 0; ; i++) {
            if (i == randomCountForPayment) {
                out.println("> Пользователь " + randomUserPayed + " оплатил платную услугу");
                redis.getOnlineUsers().remove(String.valueOf(randomUserPayed));
                redis.addOnlineUser(String.valueOf(randomUserPayed));
                setMainUserId(String.valueOf(randomUserPayed));
                tenCount++;
                randomCountForPayment = tenCount * 10 + (int) (10 * Math.random());
                randomUserPayed = (int) (20 * Math.random());
                Thread.sleep(1000);
            } else {
                String firstElement = redis.getOnlineUsers().first();
                setMainUserId(firstElement);
                redis.getOnlineUsers().remove(firstElement);
                redis.addOnlineUser(firstElement);
                Thread.sleep(1000);
            }
        }
    }
}