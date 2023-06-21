package web.pageObjects.solidPrinciple.openClosedDesign;

public class Circle implements Shape{
    public double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
