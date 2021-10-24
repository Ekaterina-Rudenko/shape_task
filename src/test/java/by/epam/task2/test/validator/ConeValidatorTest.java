package by.epam.task2.test.validator;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    @DataProvider(name = "parametersToValidate")
    public Object[][] parametersToValidate() {
        List<double[]> parameterArray = new ArrayList<>();
        parameterArray.add(new double[]{1, 1, 2, 1, 1, 10, 4.5});//true
        parameterArray.add(new double[]{1.0, 1.5, 2, 1.0, 1.5, 10, 4.5});//true
        parameterArray.add(new double[]{1.0, 1.5, 2, 1.0, 1.5, -100, 4.5});//true
        parameterArray.add(new double[]{1.0, 0.0, 2, 10.0, 1.5, 10, 4.5});//false
        parameterArray.add(new double[]{100, 1, 2, 1, 1, 10, -4.5});//negative radius
        parameterArray.add(new double[]{1, 1, 2, 1, 1, 10, 4.5, 12, 12, 12, 12, 12});//wrong size
        List<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        return new Object[][]{{parameterArray, expected}};
    }

    @Test(dataProvider = "parametersToValidate")
    public void isConeDoubleArrayTest(List<double[]> parameter, List<Boolean> expected) {
        List<Boolean> actual = new ArrayList<>();
        for (double[] array : parameter) {
            boolean result = validator.isCone(array);
            actual.add(result);
        }
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "coneForValidation")
        public Object[][] conesData(){
        List<Cone> cones = new ArrayList<>();
        cones.add(new Cone(new Point(1, 1 ,0), new Point(1, 1, 2), 100));
        cones.add(new Cone(new Point(-1.0, -1.0, 2.0), new Point(-1.0, -1.0, -7), 4));
        cones.add(new Cone( new Point(2, 2, 2), new Point(2, 2, 6), -100)); //wrong radius
        cones.add(new Cone( new Point(2, 2, 2), new Point(2, 2, 6), 0)); //zero radius
        cones.add(new Cone( new Point(2, 2, 2), new Point(2, 2, 2), 10)); //zero height
        cones.add(new Cone( new Point(-10, 2, 2), new Point(2, 2, 6), 10));//wrong coordinate
        List<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        expected.add(false);
        return new Object[][]{{cones, expected}};
    }
    @Test(dataProvider = "coneForValidation")
    public void isConeShapeTest(List<Cone> cones, List<Boolean> expected){
        List<Boolean> actual = new ArrayList<>();
        for(Cone cone : cones){
            boolean isValid = validator.isCone(cone);
            actual.add(isValid);
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isConePointTest() {
        Point centre = new Point(1, 1, 2);
        Point apex = new Point(1, 1, 10);
        boolean actual = validator.isCone(centre, apex, 4.0);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void isConePointNegativeTest() {
        Point centre = new Point(0, 10, 2);
        Point apex = new Point(10, 10, 10);
        boolean actual = validator.isCone(centre, apex, 4.0);
        Assert.assertNotEquals(actual, true);
    }

    @DataProvider(name = "dissectionHeightData")
    public Object[][] dissectionTestData(){
        List<Double> dissectionHeight = new ArrayList<>();
        dissectionHeight.add(5.0);
        dissectionHeight.add(1.1);
        dissectionHeight.add(10.0);//high border value
        dissectionHeight.add(1.0);//low border value
        dissectionHeight.add(-5.0);
        dissectionHeight.add(100.0);
        List<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(true);
        expected.add(false);
        expected.add(false);
        return new Object[][]{{dissectionHeight, expected}};
    }
    @Test(dataProvider = "dissectionHeightData")
    public void checkDissectionHeightTest() {
        Cone correctCone = new Cone(new Point(1, 1, 1), new Point(1, 1, 10), 4.0);

        double dissectionHeight = 3.0;
        boolean actual = validator.checkDissectionHeight(correctCone, dissectionHeight);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void checkDissectionHeightNegativeTest() {
        Cone correctCone = new Cone(new Point(1, 1, 1), new Point(1, 1, 5), 4.0);
        double dissectionHeight = 100.0;
        boolean actual = validator.checkDissectionHeight(correctCone, dissectionHeight);
        Assert.assertNotEquals(actual, true);
    }
}
