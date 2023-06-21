package ddt.solidPrinciple;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import web.pageObjects.solidPrinciple.liskovSubstitution.Rectangle;
import web.pageObjects.solidPrinciple.liskovSubstitution.Square;

public class LiskovSubstitutionTest {
    @Description("Test description: Solid with liskov substitution test")
    @Story("Solid")
    @Test
    public void liskovSubstitution(){
        Rectangle rc = new Rectangle(2, 3);
        getAreaTest(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        getAreaTest(sq);
    }
    void getAreaTest(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());
    }
}
