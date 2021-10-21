package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Cone> {
    public int compare(Cone o1, Cone o2) {
        double radius1 = o1.getRadius();
        double radius2 = o2.getRadius();
        return Double.compare(radius1, radius2);
    }
}
