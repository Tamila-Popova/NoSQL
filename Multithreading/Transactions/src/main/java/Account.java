public class Account {
    private long money;
    private String accNumber;
    private boolean isBlocked = false;
    public Account(String accNumber, long money){
        this.money = money;
        this.accNumber = accNumber;
    }

    public void blocked() {
       this.isBlocked = true;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
