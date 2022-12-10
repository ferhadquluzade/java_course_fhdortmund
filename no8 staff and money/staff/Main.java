
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Manager mng1 = new Manager("Johnny", 35000, 25000);
        Manager mng2 = new Manager("Duke", 50000, 25000);
        Employee emp1 = new Employee("Mary", 42000, 0);
        Employee emp2 = new Employee("Steve", 45000, 0);

        List<Staff> staffList = new ArrayList<Staff>(Arrays.asList( mng1, mng2,emp1, emp2));
        staffList.forEach(mem -> System.out.println("Name:" + mem.getName() + ", Base Salary:" + mem.getSalary() + ", Type:" + mem.getClass() + ", Annual Return:" + mem.getAnnualReturn() + ", Payroll:" + mem.calculatePayroll()));
    }
}