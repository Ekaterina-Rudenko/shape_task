package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone cone1, Cone cone2) {
        ConeCalculation calculation = new ConeCalculationImpl();
        double volume1 = calculation.findVolume(cone1);
        double volume2 = calculation.findVolume(cone2);
        return Double.compare(volume1, volume2);
    }
}
