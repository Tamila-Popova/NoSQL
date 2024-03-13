public class TopManager implements Employee {
    private final double PERCENT_OF_SALARY = 1.5;
    private double salaryTopManager = (int) ((Math.random() * (100_000 - 80_000)) + 80_000);
    Company company;

    public TopManager(Company company) {
        if (company.getIncome() > 10_000_000) {
            salaryTopManager += salaryTopManager * PERCENT_OF_SALARY;
        } else salaryTopManager = salaryTopManager;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return salaryTopManager;
    }

    public String toString() {
        return "Топ-менеджер: " + getMonthSalary() + "руб.";
    }
}
