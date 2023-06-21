package web.pageObjects.patterns.decorator;

public class Developer extends EmployeeDecorator{
    public Developer(Employee employee) {
        super(employee);
    }

    public void performCodingFeatureTask(String taskName) {
        System.out.println(employee.getName() + " is coding for" + taskName);
    }
}
