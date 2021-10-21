package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class CentreYComparator implements Comparator<Cone> {
    public int compare(Cone o1, Cone o2) {
        double y1 = o1.getCentrePoint().getY();
        double y2 = o2.getCentrePoint().getY();
        return Double.compare(y1, y2);
    }
}
