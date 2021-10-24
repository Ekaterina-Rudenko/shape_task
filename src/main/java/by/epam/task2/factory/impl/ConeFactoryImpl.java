package by.epam.task2.factory.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.CustomException;
import by.epam.task2.factory.ConeFactory;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConeFactoryImpl implements ConeFactory {
    static Logger logger = LogManager.getLogger();
    ConeValidator validator = ConeValidatorImpl.getInstance();
    PointFactoryImpl pointFactoryImpl = new PointFactoryImpl();

    @Override
    public Cone createCone(double[] coordinatesDouble) throws CustomException {
        if (!validator.isCone(coordinatesDouble)) {
            logger.log(Level.ERROR, "The parameters " + Arrays.toString(coordinatesDouble) + " for creating a cone are incorrect ");
            throw new CustomException("The parameters " + Arrays.toString(coordinatesDouble) + " for creating a cone are incorrect ");
        }
        Point centre = pointFactoryImpl.createPoint(coordinatesDouble[ConeValidatorImpl.INDEX_CENTRE_X],
                coordinatesDouble[ConeValidatorImpl.INDEX_CENTRE_Y],
                coordinatesDouble[ConeValidatorImpl.INDEX_CENTRE_Z]
        );
        Point apex = pointFactoryImpl.createPoint(coordinatesDouble[ConeValidator.INDEX_APEX_X],
                coordinatesDouble[ConeValidator.INDEX_APEX_Y],
                coordinatesDouble[ConeValidator.INDEX_APEX_Z]
        );
        double radius = coordinatesDouble[ConeValidator.INDEX_RADIUS];
        return new Cone(centre, apex, radius);
    }

    @Override
    public Cone createCone(Point centre, Point apex, double radius) throws CustomException {
        if (!validator.isCone(centre, apex, radius)) {
            logger.log(Level.ERROR, "The parameters " + centre + ", " + apex + ", " + radius + " for creating a cone are incorrect ");
            throw new CustomException("The parameters " + centre + ", " + apex + ", " + radius + " for creating a cone are incorrect ");
        }
        return new Cone(centre, apex, radius);
    }

    @Override
    public Cone createCone(double centreX, double centreY, double centreZ, double apexX, double apexY, double apexZ, double radius) throws CustomException {
        if (!validator.isCone(centreX, centreY, centreZ, apexX, apexY, apexZ, radius)) {
            logger.log(Level.ERROR, "The parameters for creating a cone are incorrect ");
            throw new CustomException("The parameters for creating a cone are incorrect ");
        }
        Point centre = pointFactoryImpl.createPoint(centreX, centreY, centreZ);
        Point apex = pointFactoryImpl.createPoint(apexX, apexY, apexZ);
        return new Cone(centre, apex, radius);
    }

    @Override
    public List<Cone> createConeList(List<double[]> coneParameter) throws CustomException {
        List<Cone> coneList = new ArrayList<>();
        for (double[] array : coneParameter) {
            Cone cone = createCone(array);
            coneList.add(cone);
        }
        return coneList;
    }
}
