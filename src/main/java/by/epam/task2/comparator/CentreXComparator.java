package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class CentreXComparator implements Comparator<Cone> {
    public int compare(Cone o1, Cone o2) {
        double x1 = o1.getCentrePoint().getX();
        double x2 = o2.getCentrePoint().getX();
        return Double.compare(x1, x2);
    }
}
