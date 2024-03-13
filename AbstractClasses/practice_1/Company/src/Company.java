
import java.util.*;

public class Company {

    private ArrayList<Employee> employees = new ArrayList<>();
    public double incomeOfCompany;

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        ArrayList topSalaryStaff = new ArrayList();
        Collections.sort(employees);
        Collections.reverse(employees);
        for (int i = 0; i < count; i++) {
            topSalaryStaff.add(employees.get(i));
        }
        return topSalaryStaff;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        ArrayList lowerSalaryStaff = new ArrayList();
        Collections.sort(employees);
        for (int i = 0; i < count; i++) {
            lowerSalaryStaff.add(employees.get(i));
        }
        return lowerSalaryStaff;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void calculateIncome() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                incomeOfCompany += ((Manager) employee).getEarnedMoneyForCompany();
            }
        }
    }

    public double getIncome() {
        calculateIncome();
        return incomeOfCompany;
    }
}
