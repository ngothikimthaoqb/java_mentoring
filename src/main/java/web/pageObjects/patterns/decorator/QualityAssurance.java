package web.pageObjects.patterns.decorator;

public class QualityAssurance extends EmployeeDecorator{
    public QualityAssurance(Employee employee) {
        super(employee);
    }

    public void performTestingFeatureTask(String taskName) {
        System.out.println(employee.getName() + " is testing for " + taskName);
    }
}
