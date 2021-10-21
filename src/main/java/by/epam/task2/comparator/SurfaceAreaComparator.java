package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.warehouse.Warehouse;

import java.util.Comparator;

public class SurfaceAreaComparator implements Comparator<Cone> {
    public int compare(Cone cone1, Cone cone2) {
        Warehouse warehouse = Warehouse.getInstance();
        double surfaceArea1 = 0;
        double surfaceArea2 = 0;
        try {
            surfaceArea1 = warehouse.getParameter(cone1.getConeId()).getSurfaceArea();
            surfaceArea2 = warehouse.getParameter(cone2.getConeId()).getSurfaceArea();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return Double.compare(surfaceArea1, surfaceArea2);
    }
}
