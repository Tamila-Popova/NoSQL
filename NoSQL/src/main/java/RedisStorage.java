import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.time.Instant;
import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {
    // Объект для работы с Redis
    private RedissonClient redisson;
    // Объект для работы с ключами
    private RKeys rKeys;
    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> onlineUsers;
    private final static String KEY = "ONLINE_USERS";

    public RScoredSortedSet<String> getOnlineUsers() {
        return onlineUsers;
    }

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    // Пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for (String key : keys) {
            out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    void calculateUsersNumber(int count) {
        try {
            for (int i = 0; i < count; i++) {
                String userId = String.valueOf(i);
                Instant instant = Instant.now();
                onlineUsers.add(instant.toEpochMilli(), userId);
                Thread.sleep((int) (Math.random() * 10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void addOnlineUser(String userId) {
        Instant instant = Instant.now();
        onlineUsers.add(instant.toEpochMilli(), userId);
    }
}