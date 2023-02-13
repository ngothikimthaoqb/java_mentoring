package calculator;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    public CalculatorTest() {
    }

    @BeforeClass
    public void init() {
        this.calculator = new Calculator();
    }

    @Test(
            dataProvider = "testSumWithLongType",
            dataProviderClass = CalculatorDataProvider.class
    )
    public void testSumWithLongType(long a, long b, long result) {
        long sumActual = this.calculator.sum(a, b);
        Assert.assertEquals(sumActual, result, "Sum test with long type failed.");
    }

    @Test(
            dataProvider = "testSumWithDoubleType",
            dataProviderClass = CalculatorDataProvider.class
    )
    public void testSumWithDoubleType(double a, double b, double result) {
        double sumActual = this.calculator.sum(a, b);
        Assert.assertEquals(sumActual, result, "Sum test with double failed.");
    }

    @Test(
            dataProvider = "testSubWithLongType",
            dataProviderClass = CalculatorDataProvider.class
    )
    public void testSubWithLongType(long a, long b, long result) {
        long subActual = this.calculator.sub(a, b);
        Assert.assertEquals(subActual, result, "Sub test with long type failed.");
    }

    @Test(
            dataProvider = "testSubWithDoubleType",
            dataProviderClass = CalculatorDataProvider.class
    )
    public void testSubWithDoubleType(double a, double b, double result) {
        double subActual = this.calculator.sub(a, b);
        Assert.assertEquals(subActual, result, "Sub test with double failed.");
    }

    @Test
    public void testMulWithLongType() {
        long mulActual = this.calculator.mult(3L, 4L);
        Assert.assertEquals(mulActual, 12L, "Mul test with long type failed.");
    }

    @Test
    public void testMulWithDoubleType() {
        double mulActual = this.calculator.mult(7.0, 8.0);
        Assert.assertEquals(mulActual, 56.0, "Mul test with double failed.");
    }

    @Test
    public void testDivWithLongType() {
        long divActual = this.calculator.div(12L, 4L);
        Assert.assertEquals(divActual, 3L, "Div test with long type failed.");
    }

    @Test
    public void testDivWithDoubleType() {
        double divActual = this.calculator.div(36.0, 6.0);
        Assert.assertEquals(divActual, 6.0, "Div test with double failed.");
    }

    @Test
    public void testPow() {
        double powActual = this.calculator.pow(6.0, 6.0);
        Assert.assertEquals(powActual, 46656.0, "Pow test failed.");
    }

    @Test
    public void testSqrt() {
        double sqrtActual = this.calculator.sqrt(9.0);
        Assert.assertEquals(sqrtActual, 3.0, "Sqrt test failed.");
    }

    @Test
    public void testCtg() {
        double ctgActual = this.calculator.ctg(9.0);
        Assert.assertEquals(ctgActual, 0.999999969540041, "Ctg test failed.");
    }

    @Test
    public void testCos() {
        double cosActual = this.calculator.cos(3.0);
        Assert.assertEquals(cosActual, 0.1411200080598672, "Cos test failed.");
    }

    @Test
    public void testSin() {
        double sinActual = this.calculator.sin(9.0);
        Assert.assertEquals(sinActual, 0.4121184852417566, "Sin test failed.");
    }

    @Test
    public void testIsPositive() {
        boolean isPositiveActual = this.calculator.isPositive(9L);
        Assert.assertTrue(isPositiveActual, "Is positive test failed.");
    }

    @Test
    public void testIsNegative() {
        boolean isNegativeActual = this.calculator.isNegative(-9L);
        Assert.assertTrue(isNegativeActual, "Is negative test failed.");
    }
}
