package calculator;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    public CalculatorDataProvider() {
    }

    @DataProvider(
            name = "testSumWithLongType"
    )
    public Object[][] testSumWithLongType() {
        return new Object[][]{{3L, 4L, 7L}, {5L, 6L, 11L}};
    }

    @DataProvider(
            name = "testSumWithDoubleType"
    )
    public Object[][] testSumWithDoubleType() {
        return new Object[][]{{7.832, 1, 8.832}, {-7.832, -1, -8.832}};
    }

    @DataProvider(
            name = "testSubWithLongType"
    )
    public Object[][] testSubWithLongType() {
        return new Object[][]{{7L, 4L, 3L}, {5L, 6L, -1L}};
    }

    @DataProvider(
            name = "testSubWithDoubleType"
    )
    public Object[][] testSubWithDoubleType() {
        return new Object[][]{{5.0, 4.0, 1.0}, {5.0, 1.0, 4.0}};
    }
}
