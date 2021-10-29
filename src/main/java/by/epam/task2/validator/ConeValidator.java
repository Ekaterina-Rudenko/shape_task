package by.epam.task2.validator;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;

public interface ConeValidator {
    boolean isCone(double... parameter);

    boolean isCone(Cone cone);

    boolean isCone(Point centre, Point apex, double radius);

    boolean checkDissectionHeight(Cone cone, double height);

}
