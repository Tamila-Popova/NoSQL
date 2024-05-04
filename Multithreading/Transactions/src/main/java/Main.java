import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Map<String, Account> accounts = new HashMap<>();
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            long money = random.nextLong(100_000, 500_000);
            Account account = new Account(String.valueOf(i), money);
            accounts.put(String.valueOf(i), account);
        }
        bank.setAccounts(accounts);

        for (int i = 0; i <= 100; i++) {
            String account1 = String.valueOf((int) (Math.random() * 10_000));
            String account2 = String.valueOf((int) (Math.random() * 10_000));
            long amount = (long) (Math.random() * 100_000);
            System.out.println("Сумма в банке: " + bank.getSumAllAccounts());
            Thread thread = new Thread(() -> {
                try {
                    bank.transfer(account1, account2, amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();
        }
    }
}
