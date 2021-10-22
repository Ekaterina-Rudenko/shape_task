package by.epam.task2.test.reader;

import by.epam.task2.exception.CustomException;
import by.epam.task2.reader.InfoReader;
import by.epam.task2.reader.impl.InfoReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InfoReaderTest {
    InfoReader reader;

    @BeforeClass
    public void create() {
        reader = new InfoReaderImpl();
    }

    @Test
    public void readDataTest() throws CustomException {
        List<String> actual = reader.readData("testData/test.txt");
        List<String> expected = new ArrayList<>();
        expected.add("sdgb,dsmbfns,d");
        expected.add("1.0 2.0 0.0 1.0 2.0 6.0 3.5");
        expected.add("sdfba,mbfnakr");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void readDataEmptyTest() throws CustomException {
        List<String> actual = reader.readData("testData/empty.txt");
        List<String> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void readDataWrongPathTest() throws CustomException {
        List<String> actual = reader.readData("testData/wrong.txt");
    }
}
