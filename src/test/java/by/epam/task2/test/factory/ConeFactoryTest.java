package by.epam.task2.test.factory;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.CustomException;
import by.epam.task2.factory.ConeFactory;
import by.epam.task2.factory.impl.ConeFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConeFactoryTest {
    ConeFactory coneFactory;

    @BeforeClass
    public void setConeFactory() {
        coneFactory = new ConeFactoryImpl();
    }

    @DataProvider(name = "dataForFactory")
    public Object[][] dataForFactory() {
        List<double[]> parametersList = new ArrayList<>();
        parametersList.add(new double[]{1.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.5});
        parametersList.add(new double[]{100.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.5});//will be filtered as incorrect while creating
        parametersList.add(new double[]{-1.0, -2.0, 0.0, -1.0, -2.0, 6.0, 3.0});
        parametersList.add(new double[]{1.0, -2.0, 0.0, 1.0, -2.0, -6.0, 3.0});
        parametersList.add(new double[]{1.2, 1.0, 2.0, 1.2, 1.0, 2.0, 7.0});//will be filtered as incorrect while creating
        parametersList.add(new double[]{100, 1, 10, 100, 1, 100, 7.0});
        List<Cone> coneList = new ArrayList<>();
        coneList.add(new Cone(new Point(1.0, 2.0, 0.0), new Point(1.0, 2.0, 6.0), 3.5));
        coneList.add(new Cone(new Point(-1.0, -2.0, 0.0), new Point(-1.0, -2.0, 6.0), 3.0));
        coneList.add(new Cone(new Point(1.0, -2.0, 0.0), new Point(1.0, -2.0, -6.0), 3.0));
        coneList.add(new Cone(new Point(100, 1, 10), new Point(100, 1, 100), 7));
        return new Object[][]{{parametersList, coneList}};
    }

    @Test(dataProvider = "dataForFactory")
    public void createConeTest(List<double[]> parameterList, List<Cone> expectedConeList) throws CustomException {
        List<Cone> coneList = coneFactory.createConeList(parameterList);
        List<Boolean> actual = new ArrayList<>();
        
        int index = 0;
        for (Cone cone : coneList) {
            boolean result = cone.equalsIgnoreId(expectedConeList.get(index));
            index++;
            actual.add(result);
        }
        List<Boolean> expected = List.of(true, true, true, true);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createConeFromDoublesTest() throws CustomException {
        Cone actual = coneFactory.createCone(1, 1, 2, 1, 1, 5, 10);
        Cone expected = new Cone(new Point(1, 1, 2), new Point(1, 1, 5), 10);
        Assert.assertTrue(actual.equalsIgnoreId(expected));
    }

    @Test(expectedExceptions = CustomException.class)
    public void createConeExceptionTest() throws CustomException {
        Cone actual = coneFactory.createCone(1, 2, 10, -5, 3, 20, 8);
    }

}

