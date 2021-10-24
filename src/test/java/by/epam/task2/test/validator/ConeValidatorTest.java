package by.epam.task2.test.validator;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeValidatorTest {
    ConeValidator validator;
    Cone correctCone;
    Cone wrongCone;

    @BeforeClass
    public void create() {
        validator = ConeValidatorImpl.getInstance();
        correctCone = new Cone(new Point(1, 1, 1), new Point(1, 1, 5), 4.0);
        wrongCone = new Cone(new Point(100, 1, 1), new Point(1, 1, 5), 4.0);
    }

    @Test
    public void isConeDoubleArrayTest() {
        boolean actual = validator.isCone(1, 1, 2, 1, 1, 10, 4.5);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void isConeDoubleArrayNegativeTest() {
        boolean actual = validator.isCone(100, 1, 2, 1, 1, 10, -4.5);
        Assert.assertNotEquals(actual, true);
    }

    @Test
    public void isConeDoubleArrayWrongSizeTest() {
        boolean actual = validator.isCone(100, 1, 2, 1, 1, 10, -4.5, 12, 12, 12, 12, 12);
        Assert.assertNotEquals(actual, true);
    }

    @Test
    public void isConeTest() {
        Point centre = new Point(1, 1, 2);
        Point apex = new Point(1, 1, 10);
        boolean actual = validator.isCone(centre, apex, 4.0);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void isConeNegativeTest() {
        Point centre = new Point(0, 10, 2);
        Point apex = new Point(10, 10, 10);
        boolean actual = validator.isCone(centre, apex, 4.0);
        Assert.assertNotEquals(actual, true);
    }

    @Test
    public void isConeShapeTest() {
        boolean actual = validator.isCone(correctCone);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void isConeShapeNegativeTest() {
        boolean actual = validator.isCone(wrongCone);
        Assert.assertNotEquals(actual, true);
    }
    @Test
    public void checkDissectionHeightTest(){
        double dissectionHeight = 3.0;
        boolean actual = validator.checkDissectionHeight(correctCone, dissectionHeight);
        Assert.assertEquals(actual, true);
    }
    @Test
    public void checkDissectionHeightNegativeTest(){
        double dissectionHeight = 100.0;
        boolean actual = validator.checkDissectionHeight(correctCone, dissectionHeight);
        Assert.assertNotEquals(actual, true);
    }
}
