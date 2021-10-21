package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;

import java.util.Comparator;

public class ConeIdComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2){
        return Long.compare(o1.getConeId(), o2.getConeId());
    }
}
