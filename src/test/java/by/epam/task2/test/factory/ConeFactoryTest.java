package by.epam.task2.test.factory;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.CustomException;
import by.epam.task2.factory.ConeFactory;
import by.epam.task2.factory.impl.ConeFactoryImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class ConeFactoryTest {
    ConeFactory coneFactory;
    @BeforeClass
    public void setConeFactory(){
        coneFactory = new ConeFactoryImpl();
    }
    @DataProvider(name = "dataForFactory")
    public Object[][] dataForFactory() {
        List<double[]> parametersList = new ArrayList<>();
        parametersList.add(new double[]{200.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.5});
        parametersList.add(new double[]{1.0, 2.0, 0.0, 1.0, 2.0, 6.0, 3.0});
        parametersList.add(new double[]{1.0, -2.0, 0.0, 1.0, -2.0, -6.0, 3.0});
        parametersList.add(new double[]{1.2, 1.0, 2.0, 1.2, 1.0, 7.0, 7.0});
        parametersList.add(new double[]{1.2, 1.2, 10.0, 1.2, 1.2, 100.0, 7.0});
        return new Object[][]{{parametersList}};
    }}
/*    Cone createCone(double[] coordinatesDouble) throws CustomException;

    Cone createCone(Point centre, Point apex, double radius) throws CustomException;

    Cone createCone(double centreX, double centreY, double centreZ, double apexX, double apexY, double apexZ, double radius) throws CustomException;

    List<Cone> createConeList(List<double[]> coneParameter) throws CustomException;
}*/
