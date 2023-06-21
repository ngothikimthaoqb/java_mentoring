package web.pageObjects.patterns.decorator;

public class BusinessAnalyst extends EmployeeDecorator{
    public BusinessAnalyst(Employee employee) {
        super(employee);
    }

    public void planing(String sprint) {
        System.out.println(employee.getName() + " is planing for " + sprint);

    }

    public void createUserStory(){
        System.out.println(employee.getName() + " is creating user story");
    }
}
