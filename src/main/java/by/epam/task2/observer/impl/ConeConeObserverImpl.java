package by.epam.task2.observer.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.observer.ConeEvent;
import by.epam.task2.observer.ConeObserver;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import by.epam.task2.warehouse.ConeParameter;
import by.epam.task2.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeConeObserverImpl implements ConeObserver {
    static Logger logger = LogManager.getLogger();

    @Override
    public void updateSurfaceArea(ConeEvent coneEvent) throws CustomException {
        Cone cone = coneEvent.getSource();
        ConeValidator validator = ConeValidatorImpl.getInstance();
        if (!validator.isCone(cone)) {
            logger.log(Level.ERROR, "Cone became invalid " + cone);
            throw new CustomException("Cone became invalid " + cone);
        }
        ConeCalculation coneCalculation = new ConeCalculationImpl();
        Warehouse warehouse = Warehouse.getInstance();
        long coneId = cone.getConeId();
        ConeParameter coneParameter = warehouse.getParameter(coneId);
        double surfaceArea = coneCalculation.findSurfaceArea(cone);
        coneParameter.setSurfaceArea(surfaceArea);
        warehouse.putParameter(coneId, coneParameter);
    }

    @Override
    public void updateVolume(ConeEvent coneEvent) throws CustomException {
        Cone cone = coneEvent.getSource();
        ConeCalculation coneCalculation = new ConeCalculationImpl();
        Warehouse warehouse = Warehouse.getInstance();
        long coneId = cone.getConeId();
        ConeParameter coneParameter = warehouse.getParameter(coneId);
        double volume = coneCalculation.findVolume(cone);
        coneParameter.setVolume(volume);
        warehouse.putParameter(coneId, coneParameter);
    }

    @Override
    public void parameterChanged(ConeEvent coneEvent) throws CustomException {
        Cone cone = coneEvent.getSource();
        ConeValidator validator = ConeValidatorImpl.getInstance();
        if (!validator.isCone(cone)) {
            logger.log(Level.ERROR, "Cone became invalid " + cone);
            throw new CustomException("Cone became invalid " + cone);
        }
        ConeCalculation coneCalculation = new ConeCalculationImpl();
        double surfaceArea = coneCalculation.findSurfaceArea(cone);
        double volume = coneCalculation.findVolume(cone);
        Warehouse warehouse = Warehouse.getInstance();
        long coneId = cone.getConeId();
        warehouse.putParameter(coneId, surfaceArea, volume);
    }
}
