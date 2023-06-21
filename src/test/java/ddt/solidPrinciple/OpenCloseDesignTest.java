package ddt.solidPrinciple;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.pageObjects.solidPrinciple.openClosedDesign.Circle;
import web.pageObjects.solidPrinciple.openClosedDesign.Rectangle;

public class OpenCloseDesignTest {

    @Description("Test description: Solid with open and close design test")
    @Story("Solid")
    @Test
    public void openCloseDesign(){
       // Calculate Circle area
        double radius = 3;
        Circle circle = new Circle(radius);
        Assert.assertEquals(circle.calculateArea(), Math.PI * radius * radius );

        // Calculate Rectangle area
        double length = 3;
        double width = 2;
        Rectangle rectangle = new Rectangle(length, width);
        Assert.assertEquals(rectangle.calculateArea(), length * width );

    }
}
