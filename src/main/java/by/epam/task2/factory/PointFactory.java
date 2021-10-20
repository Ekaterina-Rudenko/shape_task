package by.epam.task2.factory;

import by.epam.task2.entity.Point;

public interface PointFactory {
    Point createPoint(double x, double y, double z);
}
