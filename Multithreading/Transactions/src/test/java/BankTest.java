import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


public class BankTest{
    @Test
    public void transferAndBalanceTest() throws InterruptedException{
        Bank bank = new Bank();
        HashMap<String, Account> accounts = new HashMap<>();
        Account account1 = new Account("1", 100000);
        Account account2 = new Account("2", 50000);
        accounts.get(account1);
        accounts.get(account2);
        bank.setAccounts(accounts);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0; i<1000; i++){
            executorService.submit(() -> {
                try{bank.transfer("1", "2", 100);
                    long balance = bank.getBalance("1");
                    System.out.println("Balance: " + balance);}
                catch (InterruptedException e){e.printStackTrace();}
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

         assertEquals(account1.getMoney()+account2.getMoney(), bank.getSumAllAccounts());
    }
    @Test
    public void testFraud() throws InterruptedException{
        Bank bank = new Bank();
        HashMap<String, Account> accounts = new HashMap<>();
        Account account1 = new Account("1", 100000);
        Account account2 = new Account("2", 50000);
        accounts.get(account1);
        accounts.get(account2);
        bank.setAccounts(accounts);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i<5; i++){
            executorService.submit(() -> {
                try {bank.transfer("1", "2", 60000);

                }catch (InterruptedException e){e.printStackTrace();}
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(account1.getMoney()+account2.getMoney(), bank.getSumAllAccounts());
    }
}
