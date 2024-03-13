public class Manager implements Employee {
    Company company;
    private final double PERCENT_OF_INCOME = 0.05;
    public double salaryManager = (int) ((Math.random() * (80_000 - 60_000)) + 60_000);
    private final double earnedMoneyForCompany = (int) ((Math.random() * (140_000 - 115_000)) + 115_000);

    public double getEarnedMoneyForCompany() {
        return earnedMoneyForCompany;
    }

    public Manager(Company company) {
        this.company = company;
        this.salaryManager += earnedMoneyForCompany * PERCENT_OF_INCOME;
    }

    public double getMonthSalary() {
        return salaryManager;
    }

    public String toString() {
        return "Менеджер: " + getMonthSalary() + "руб.";
    }
}
