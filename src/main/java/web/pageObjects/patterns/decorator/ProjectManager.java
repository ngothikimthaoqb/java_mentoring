package web.pageObjects.patterns.decorator;

public class ProjectManager extends EmployeeDecorator {
    public ProjectManager(Employee employee) {
        super(employee);
    }

    public void assignTask() {
        System.out.println(this.employee.getName() + " is assigning tasks.");
    }

    public void collectReport() {
        System.out.println(this.employee.getName() + " is collecting report");
    }
}
