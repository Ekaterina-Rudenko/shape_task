package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class CentreZComparator implements Comparator<Cone> {
    public int compare(Cone o1, Cone o2) {
        double z1 = o1.getCentrePoint().getZ();
        double z2 = o2.getCentrePoint().getZ();
        return Double.compare(z1, z2);
    }
}
