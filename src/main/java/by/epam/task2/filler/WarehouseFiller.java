package by.epam.task2.filler;

import by.epam.task2.entity.Cone;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.warehouse.ConeParameter;
import by.epam.task2.warehouse.Warehouse;
import java.util.List;

public class WarehouseFiller {
    public void fillWarehouse(Cone cone) {
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
    public void fillWarehouse(List<Cone> coneList) {
        for (Cone cone : coneList) {
            fillWarehouse(cone);
        }
    }
}
