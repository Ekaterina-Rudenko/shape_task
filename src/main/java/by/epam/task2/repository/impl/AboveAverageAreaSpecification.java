package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import by.epam.task2.warehouse.Warehouse;

public class AboveAverageAreaSpecification implements Specification {
    @Override
    public boolean specify(Cone cone){
        Warehouse warehouse = Warehouse.getInstance();
        ConeCalculation calculation = new ConeCalculationImpl();
        double averageSurfaceArea = calculation.averageSurfaceArea();
        double surfaceArea = warehouse.getCone(cone.getConeId()).getSurfaceArea();
        return (surfaceArea > averageSurfaceArea);
    }
}
