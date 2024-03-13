public class Operator implements Employee {
    private double salaryOperator = (int) ((Math.random() * (70_000 - 50_000)) + 50_000);
    Company company;

    public Operator(Company company) {
        this.company = company;
        this.salaryOperator = salaryOperator;
    }

    @Override
    public double getMonthSalary() {
        return salaryOperator;
    }

    public String toString() {
        return "Оператор: " + getMonthSalary() + "руб.";
    }
}
