package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.repository.Specification;

public class FirstQuarterSpecification implements Specification {
    @Override
    public boolean specify(Cone cone) {
        double radius = cone.getRadius();
        double centreX = cone.getCentrePoint().getX();
        double centreY = cone.getCentrePoint().getY();
        return ((centreX - radius) > 0) && ((centreY - radius) > 0);
    }
}
