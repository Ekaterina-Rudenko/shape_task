package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;
import by.epam.task2.warehouse.Warehouse;

import java.util.Comparator;

public class SurfaceAreaComparator implements Comparator<Cone> {
    public int compare(Cone cone1, Cone cone2) {
        Warehouse warehouse = Warehouse.getInstance();
        double surfaceArea1 = warehouse.getCone(cone1.getConeId()).getSurfaceArea();
        double surfaceArea2 = warehouse.getCone(cone2.getConeId()).getSurfaceArea();
        return Double.compare(surfaceArea1, surfaceArea2);
    }
}
