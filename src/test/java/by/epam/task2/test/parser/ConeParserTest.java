package by.epam.task2.test.parser;

import by.epam.task2.exception.CustomException;
import by.epam.task2.parser.ConeParser;
import by.epam.task2.parser.impl.ConeParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeParserTest {
    ConeParser parser;

    @BeforeClass
    public void setParser() {
        parser = new ConeParserImpl();
    }

    @DataProvider(name = "dataForParsing")
    public Object[][] dataForParsing() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1.0 2.0 0.0 1.0 2.0 6.0 3.5");
        parameters.add("1000.0 2.0 0.0 1.0 2.0 6.0 3.5");//should be filtered and excluded from the result
        parameters.add("1.0 2.0 0.0 1.0 2.0 6.0 -3000.5");//should be filtered and excluded from the result
        parameters.add("1 2 0 1 2 6 3");
        parameters.add("+1 -2 0 +1 -2 -6 +3");
        parameters.add("1.2 1.0 2   1.2 1.0 7  +7");
        parameters.add("1.2 1.2 10 1.2 1.2 100 7   ");
        List<double[]> expected = new ArrayList<>();
        expected.add(new double[]{1.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.5});
        expected.add(new double[]{1.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.0});
        expected.add(new double[]{1.0, -2.0, 0.0, 1.0, -2.0, -6.0, 3.0});
        expected.add(new double[]{1.2, 1.0, 2.0, 1.2, 1.0, 7.0, 7.0});
        expected.add(new double[]{1.2, 1.2, 10.0, 1.2, 1.2, 100.0, 7.0});
        return new Object[][]{{parameters, expected}};
    }

    @Test(dataProvider = "dataForParsing")
    public void parseParameterToListTest(List<String> parameter, List<double[]> expected) throws CustomException {
        List<double[]> actual = parser.parseParameterToList(parameter);
        Assert.assertEquals(actual.toArray(), expected.toArray());
    }

    @Test(dataProvider = "dataForParsing")
    public void parseParameterToArrayTest(List<String> parameter, List<double[]> expected) throws CustomException {
        double[] actual = parser.parseParameter(parameter.get(0));
        Assert.assertEquals(actual, expected.get(0));
    }

    @Test(dataProvider = "dataForParsing", expectedExceptions = CustomException.class)
    public void parseParameterToArrayExceptionTest(List<String> parameter, List<double[]> result) throws CustomException {
        double[] actual = parser.parseParameter(parameter.get(2));
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseParameterToArrayNegativeTest() throws CustomException {
        String invalidLine = "1er, 2, 3, 4, 5, 6, 7";
        double[] actual = parser.parseParameter(invalidLine);
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseParameterToListExceptionTest() throws CustomException {
        List<double[]> actual = parser.parseParameterToList(null);
    }
}