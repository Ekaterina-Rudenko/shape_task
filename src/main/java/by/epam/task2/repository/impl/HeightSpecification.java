package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.repository.Specification;

public class HeightSpecification implements Specification {
    private double minHeight;
    private double maxHeight;

    public HeightSpecification(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        double height = Math.abs(cone.getApexPoint().getZ() - cone.getCentrePoint().getZ());
        return (height <= minHeight && height >= maxHeight);
    }
}
