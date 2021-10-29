package by.epam.task2.main;

import by.epam.task2.comparator.ConeIdComparator;
import by.epam.task2.comparator.HeightComparator;
import by.epam.task2.comparator.RadiusComparator;
import by.epam.task2.comparator.VolumeComparator;
import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.factory.ConeFactory;
import by.epam.task2.factory.impl.ConeFactoryImpl;
import by.epam.task2.warehouse.WarehouseFiller;
import by.epam.task2.warehouse.impl.WarehouseFillerImpl;
import by.epam.task2.observer.impl.ConeConeObserverImpl;
import by.epam.task2.parser.ConeParser;
import by.epam.task2.parser.impl.ConeParserImpl;
import by.epam.task2.reader.impl.InfoReaderImpl;
import by.epam.task2.repository.Repository;
import by.epam.task2.repository.Specification;
import by.epam.task2.repository.impl.*;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.entity.ConeParameter;
import by.epam.task2.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    static Logger logger = LogManager.getLogger();
    private final static String DEFAULT_FILE_PATH = "data/info.txt";
    private final static int DISSECTION_HEIGHT = 2;
    private final static int MIN_FOR_HEIGHT_SPECIFICATION = 10;
    private final static int MAX_FOR_HEIGHT_SPECIFICATION = 20;

    public static void main(String[] args) throws CustomException {
        Repository repository = Repository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        InfoReaderImpl reader = new InfoReaderImpl();
        ConeParser parser = new ConeParserImpl();
        ConeFactory factory = new ConeFactoryImpl();
        ConeCalculation calculation = new ConeCalculationImpl();
        WarehouseFiller filler = new WarehouseFillerImpl();
        Specification aboveAverage = new AboveAverageAreaSpecification();
        Specification aboveXYZ = new AboveXYPlaneSpecification();
        Specification firstQuarter = new FirstQuarterSpecification();
        Specification heightSpecification = new HeightSpecification(MIN_FOR_HEIGHT_SPECIFICATION, MAX_FOR_HEIGHT_SPECIFICATION);
        Specification belowAverageVolume = new BelowAverageVolumeSpecification();

        List<String> dataList = reader.readData(DEFAULT_FILE_PATH);
        List<double[]> parameterList = parser.parseParameterToList(dataList);
        List<Cone> coneList = factory.createConeList(parameterList);
        logger.log(Level.INFO, coneList.size() + " cones have been created: " + coneList);
        for (Cone cone : coneList) {
            double volume = calculation.findVolume(cone);
            logger.log(Level.INFO, "The volume of cone" + cone.getConeId() + " is " + volume);
            double surfaceArea = calculation.findSurfaceArea(cone);
            logger.log(Level.INFO, "The surface area of cone" + cone.getConeId() + " is " + surfaceArea);
            boolean onPlane = calculation.isBaseOnPlane(cone);
            logger.log(Level.INFO, "The cone base of cone" + cone.getConeId() + " is on the coordinates plane - " + onPlane);
            double volumeRatio = calculation.dissectionVolumeRatio(cone, DISSECTION_HEIGHT);
            logger.log(Level.INFO, "For dissection height " + DISSECTION_HEIGHT + " the volume ratio for cone" + cone.getConeId() + " is " + volumeRatio);
        }
        repository.addAll(coneList);
        filler.fillWarehouse(coneList);
        OptionalDouble averageArea = calculation.averageSurfaceArea();
        logger.log(Level.INFO, "The average surface area of cones is " + averageArea);
        OptionalDouble averageVolume = calculation.averageVolume();
        logger.log(Level.INFO, "The average surface area of cones is " + averageVolume);

        repository.query(aboveAverage);
        repository.query(aboveXYZ);
        repository.query(firstQuarter);
        repository.query(heightSpecification);
        repository.query(belowAverageVolume);

        repository.sortCone(new ConeIdComparator());
        repository.sortCone(new RadiusComparator());
        repository.sortCone(new HeightComparator());
        repository.sortCone(new VolumeComparator());

        Optional<Cone> coneOptional = repository.get(2);
        Cone coneToChange = null;
        if (coneOptional.isPresent()) {
            coneToChange = coneOptional.get();
        }
        ConeParameter coneParameter = warehouse.getCone(coneToChange.getConeId());
        logger.log(Level.INFO, "The parameters of cone" + coneToChange.getConeId() + " before change: " + coneParameter);
        coneToChange.attach(new ConeConeObserverImpl());
        coneToChange.setRadius(100.0);
        coneParameter = warehouse.getCone(coneToChange.getConeId());
        logger.log(Level.INFO, "The parameters of cone" + coneToChange.getConeId() + " after change: " + coneParameter);
    }
}
