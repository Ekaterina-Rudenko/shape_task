package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.warehouse.Warehouse;

public class BelowAverageVolumeSpecification implements Specification {
    @Override
    public boolean specify(Cone cone){
        Warehouse warehouse = Warehouse.getInstance();
        ConeCalculation calculation = new ConeCalculationImpl();
        double averageVolume = calculation.averageVolume();
        double volume = warehouse.getCone(cone.getConeId()).getVolume();
        return (volume < averageVolume);
    }
}
