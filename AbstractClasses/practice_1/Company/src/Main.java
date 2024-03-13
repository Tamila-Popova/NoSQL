import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(company));
        }
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(company));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(company));
        }
        System.out.println("Всего сотрудников: " + company.getEmployees().size());
        System.out.println("Доход компании: " + (int) company.getIncome());

        List<Employee> topSalaryBefore = company.getTopSalaryStaff(5);
        System.out.println("Список из самых высоких зарплат: ");
        for (Employee employee : topSalaryBefore) {
            System.out.println(String.format("%.2f руб", employee.getMonthSalary()));
        }

        List<Employee> lowestSalaryBefore = company.getLowestSalaryStaff(5);
        System.out.println("Список из самых низких зарплат: ");
        for (Employee employee : lowestSalaryBefore) {
            System.out.println(String.format("%.2f руб", employee.getMonthSalary()));
        }

        for (int i = 0; i < company.getEmployees().size(); i++) {
            company.fire(company.getEmployees().get(i));
        }

        System.out.println("\nПосле увольнения 50% сотрудников: ");
        System.out.println("Всего сотрудников: " + company.getEmployees().size());
        System.out.println("Доход компании: " + (int) company.getIncome());

        List<Employee> topSalaryAfter = company.getTopSalaryStaff(5);
        System.out.println("Список из самых высоких зарплат: ");
        for (Employee employee : topSalaryAfter) {
            System.out.println(String.format("%.2f руб", employee.getMonthSalary()));
        }

        List<Employee> lowestSalaryAfter = company.getLowestSalaryStaff(5);
        System.out.println("Список из самых низких зарплат: ");
        for (Employee employee : lowestSalaryAfter) {
            System.out.println(String.format("%.2f руб", employee.getMonthSalary()));
        }
    }
}