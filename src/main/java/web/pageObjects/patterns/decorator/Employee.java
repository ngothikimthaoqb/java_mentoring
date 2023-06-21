package web.pageObjects.patterns.decorator;

public interface Employee {
    public void join(String joinDate);
    public void terminate(String terminateDate);
    public String getName();
}
