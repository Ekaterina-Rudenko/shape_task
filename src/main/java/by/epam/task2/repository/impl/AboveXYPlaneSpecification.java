package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.repository.Specification;

public class AboveXYPlaneSpecification implements Specification {
    @Override
    public boolean specify(Cone cone)  {
        double surface = cone.getCentrePoint().getZ();
        double apex = cone.getApexPoint().getZ();
        return (surface > 0 && apex > 0);

    }
}
