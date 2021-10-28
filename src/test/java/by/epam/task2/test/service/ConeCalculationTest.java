package by.epam.task2.test.service;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.CustomException;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ConeCalculationTest {
    ConeCalculation calculation;

    @BeforeClass
    public void create() {
        calculation = new ConeCalculationImpl();
    }

    @DataProvider(name = "dataForCalculation")
    public Object[][] dataForCalculation() {
        List<Cone> cones = new ArrayList<>();
        cones.add(new Cone(new Point(0, 0, 0), new Point(0, 0, 4), 4));
        cones.add(new Cone(new Point(-1, -1, -1), new Point(-1, -1, 0), 3));
        cones.add(new Cone(new Point(-10, -10, 0.0), new Point(-10, -10, 9), 9));
        List<Double> expected = new ArrayList<>();
        expected.add(121.352);
        expected.add(58.078);
        expected.add(614.343);
        expected.add(67.021);
        expected.add(9.425);
        expected.add(763.407);
        return new Object[][]{{cones, expected}};
    }

    @Test(dataProvider = "dataForCalculation")
    public void findSurfaceAreaTest(List<Cone> cones, List<Double> expected) throws CustomException {
        List<Double> actual = new ArrayList<>();
        for (Cone cone : cones) {
            double area = calculation.findSurfaceArea(cone);
            BigDecimal result = new BigDecimal(area).setScale(3, RoundingMode.HALF_UP);
            actual.add(result.doubleValue());
        }
        Assert.assertEquals(actual, expected.subList(0, 3));
    }

    @Test(dataProvider = "dataForCalculation")
    public void findVolumeTest(List<Cone> cones, List<Double> expected) throws CustomException {
        List<Double> actual = new ArrayList<>();
        for (Cone cone : cones) {
            double area = calculation.findVolume(cone);
            BigDecimal result = new BigDecimal(area).setScale(3, RoundingMode.HALF_UP);
            actual.add(result.doubleValue());
        }
        Assert.assertEquals(actual, expected.subList(3, 6));
    }

    @Test(dataProvider = "dataForCalculation")
    public void isBaseOnPlainTest(List<Cone> cones, List<Double> parameters) {
        List<Boolean> actual = new ArrayList<>();
        for (Cone cone : cones) {
            boolean result = calculation.isBaseOnPlane(cone);
            actual.add(result);
        }
        List<Boolean> expected = new ArrayList<>();
        expected.add(true);
        expected.add(false);
        expected.add(true);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForCalculation")
    public void dissectionVolumeRatioTest(List<Cone> cone, List<Double> parameters) throws CustomException {
        double actual = calculation.dissectionVolumeRatio(cone.get(0), 2);
        double expected = 0.143;
        Assert.assertEquals(actual, expected, 0.001);
    }

    @Test(dataProvider = "dataForCalculation", expectedExceptions = CustomException.class)
    public void volumeRatioExceptionTest(List<Cone> cone, List<Double> parameters) throws CustomException {
        double actual = calculation.dissectionVolumeRatio(cone.get(0), 10);
    }
}
