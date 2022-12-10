public class Staff {
    private String name;
    private int salary;

    private int annualReturn;
public Staff(String name, int salary, int annualReturn){
    this.name = name;
    this.salary = salary;
    this.annualReturn =  annualReturn;
}

    public int getAnnualReturn() {
        return annualReturn;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int calculatePayroll(){
        return ((getSalary()+getAnnualReturn())*60)/100;
    }
}
