package by.epam.task2.test.validator;

import by.epam.task2.validator.ConeStringValidator;
import by.epam.task2.validator.impl.ConeStringValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeStringValidatorTest {
    ConeStringValidator validator;

    @BeforeMethod
    public void setUp() {
        validator = ConeStringValidatorImpl.getInstance();
    }

    @Test(dataProvider = "dataForValidation")
    public void checkConeStringTest(List<String> lines, List<Boolean> expected) {
        List<Boolean> actual = new ArrayList<>();
        for (String line:lines) {
           boolean actualResult = validator.checkConeString(line);
           actual.add(actualResult);
        }
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidation")
    public Object[][] dataForValidation() {
        List<String> lines = new ArrayList<>();
        lines.add("1.0 2.0 0.0 1.0 2.0 6.0 3.5");
        lines.add("1 2 0 1 2 6 3");
        lines.add("+1 -2 0 +1 -2 -6 +3");
        lines.add("1.2 1.0 2   1.2 1.0 7  +7");
        lines.add("1.2 1.2 10 1.2 1.2 100 7   ");
        lines.add("1.2 1.2 10 1.2 1.2 100 -1");
        lines.add("12334567");
        lines.add("1 2 3 3 4 5 6 7 8");
        lines.add("1w ss 3 3 4 5 6 7 8");
        ArrayList<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        return new Object[][]{{lines, expected}};
    }
}
