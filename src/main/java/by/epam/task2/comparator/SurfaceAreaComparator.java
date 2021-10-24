package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;

import java.util.Comparator;

public class SurfaceAreaComparator implements Comparator<Cone> {
    public int compare(Cone cone1, Cone cone2) {
        ConeCalculation calculation = new ConeCalculationImpl();
        double surfaceArea1 = calculation.findVolume(cone1);
        double surfaceArea2 = calculation.findVolume(cone2);
        return Double.compare(surfaceArea1, surfaceArea2);
    }
}
