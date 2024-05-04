import java.util.Map;
import java.util.Random;


public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account account1 = accounts.get(fromAccountNum);
        Account account2 = accounts.get(toAccountNum);

        synchronized (account1) {
            synchronized (account2) {
                if (amount < 50_000) {
                    doTransaction(account1, account2, amount);
                } else {
                    if (amount > 50_000) {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            account1.blocked();
                            account2.blocked();
                            System.out.println("Счета заблокированы");
                        }
                    }
                }
            }
        }
    }


    private synchronized void doTransaction(Account account1, Account account2, long amount) {
        synchronized (account1) {
            synchronized (account2) {
                if (account1.getMoney() >= amount) {
                    System.out.println("\n\rБаланс счетов до операции: " + account2.getAccNumber() + ": " + account2.getMoney() + "р.; "
                            + account1.getAccNumber() + ": " + account1.getMoney() + "р.");
                    account1.setMoney(account1.getMoney() - amount);
                    account2.setMoney(account2.getMoney() + amount);
                    System.out.println("Перевод выполнен");
                    System.out.println("На счёт " + account2.getAccNumber() + " со счёта " + account1.getAccNumber() + " переведено "
                            + amount + "р."
                            + "\n\rБаланс счетов после операции: " + account2.getAccNumber() + ": " + account2.getMoney() + "р.; "
                            + account1.getAccNumber() + ": " + account1.getMoney() + "р.");
                } else {
                    System.out.println("Недостаточно средств");
                }
            }
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        if (account != null) {
            return account.getMoney();
        }
        return 0;
    }

    public synchronized long getSumAllAccounts() {
        long sum = 0;
        for (Account account : accounts.values()) {
            sum += account.getMoney();
        }
        return sum;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
