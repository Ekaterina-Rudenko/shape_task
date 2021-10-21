package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class HeightComparator implements Comparator<Cone> {
    public int compare(Cone o1, Cone o2) {
        double height1 = Math.abs(o1.getApexPoint().getZ() - o1.getCentrePoint().getZ());
        double height2 = Math.abs(o2.getApexPoint().getZ() - o2.getCentrePoint().getZ());
        return Double.compare(height1, height2);
    }
}
