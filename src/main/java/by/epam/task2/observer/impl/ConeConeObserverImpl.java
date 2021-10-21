package by.epam.task2.observer.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.observer.ConeEvent;
import by.epam.task2.observer.ConeObserver;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.warehouse.ConeParameter;
import by.epam.task2.warehouse.Warehouse;

public class ConeConeObserverImpl implements ConeObserver {
    @Override
    public void parameterChanged(ConeEvent coneEvent) throws CustomException {
        Cone cone = coneEvent.getSource();
        ConeCalculation coneCalculation = new ConeCalculationImpl();
        double surfaceArea = coneCalculation.findSurfaceArea(cone);
        double volume = coneCalculation.findVolume(cone);

        Warehouse warehouse = Warehouse.getInstance();
        long coneId = cone.getConeId();
        ConeParameter coneParameter = warehouse.getParameter(coneId);
        coneParameter.setSurfaceArea(surfaceArea);
        coneParameter.setVolume(volume);
        warehouse.putParameter(coneId, coneParameter);
    }

    @Override
    public void updateSurfaceArea(ConeEvent coneEvent) throws CustomException {
        Cone cone = coneEvent.getSource();
        ConeCalculation coneCalculation = new ConeCalculationImpl();
        double surfaceArea = coneCalculation.findSurfaceArea(cone);

        Warehouse warehouse = Warehouse.getInstance();
        long coneId = cone.getConeId();
        ConeParameter coneParameter = warehouse.getParameter(coneId);
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

}
