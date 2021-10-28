package by.epam.task2.warehouse.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.entity.ConeParameter;
import by.epam.task2.warehouse.Warehouse;
import by.epam.task2.warehouse.WarehouseFiller;

import java.util.List;

public class WarehouseFillerImpl implements WarehouseFiller {
    public void fillWarehouse(Cone cone) throws CustomException {
        long id = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        ConeCalculation service = new ConeCalculationImpl();
        ConeParameter coneParameter = new ConeParameter();
        double surfaceArea = service.findSurfaceArea(cone);
        double volume = service.findVolume(cone);
        coneParameter.setSurfaceArea(surfaceArea);
        coneParameter.setVolume(volume);
        warehouse.putParameter(id, coneParameter);
    }
    public void fillWarehouse(List<Cone> coneList) throws CustomException {
        for (Cone cone : coneList) {
            fillWarehouse(cone);
        }
    }
}
