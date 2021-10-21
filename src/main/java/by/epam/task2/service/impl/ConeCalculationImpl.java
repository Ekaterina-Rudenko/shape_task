package by.epam.task2.service.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.repository.Repository;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import by.epam.task2.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class ConeCalculationImpl implements ConeCalculation {
    static Logger logger = LogManager.getLogger();

    @Override
    public double findSurfaceArea(Cone cone) {
        double radius = cone.getRadius();
        double height = findHeight(cone);
        double slantHeight = Math.hypot(cone.getRadius(), height);
        double surfaceArea = Math.PI * radius * (radius + slantHeight);
        return surfaceArea;
    }

    @Override
    public double findVolume(Cone cone) {
        double radius = cone.getRadius();
        double height = findHeight(cone);
        double volume = coneVolume(radius, height);
        return volume;
    }

    @Override
    public double dissectionVolumeRatio(Cone cone, double dissectionHeight) throws CustomException {
        ConeValidator validator = ConeValidatorImpl.getInstance();
        if (!validator.checkDissectionHeight(cone, dissectionHeight)) {
            logger.log(Level.ERROR, "The dissection height " + dissectionHeight + " is beyond cone height ");
            throw new CustomException("The dissection height " + dissectionHeight + " is beyond cone height ");
        }
        double wholeHeight = findHeight(cone);
        double littleConeHeight = wholeHeight - dissectionHeight;
        double dissectionRadius = dissectionHeight / wholeHeight * cone.getRadius();
        double littleConeVolume = coneVolume(dissectionRadius, littleConeHeight);
        double coneVolume = findVolume(cone);
        double volumeRatio = littleConeVolume / (coneVolume - littleConeVolume);
        return volumeRatio;
    }

    @Override
    public boolean isBaseOnPlane(Cone cone) {
        boolean onPlane = (cone.getCentrePoint().getX() == 0 && cone.getCentrePoint().getY() == 0);
        logger.log(Level.INFO, "The cone base is on the coordinates plane - " + onPlane);
        return onPlane;
    }

    @Override
    public double averageSurfaceArea() throws CustomException {
        Repository repository = Repository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        double totalSurface = 0;
        List<Cone> cones = repository.getCones();
        for (Cone c : cones) {
            totalSurface += warehouse.getCone(c.getConeId()).getSurfaceArea();
        }
        double averageSurface = totalSurface / cones.size();
        return averageSurface;
    }

    private double findHeight(Cone cone) {
        double height = Math.abs(cone.getApexPoint().getZ() - cone.getCentrePoint().getZ());
        return height;
    }

    private double coneVolume(double radius, double height) {
        return (1 / 3 * Math.PI * Math.pow(radius, 2) * height);
    }
}
