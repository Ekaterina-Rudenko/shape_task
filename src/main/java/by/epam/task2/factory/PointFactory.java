package by.epam.task2.factory;

import by.epam.task2.entity.Point;

public class PointFactory {
    public Point createPoint(double x, double y, double z){
        return new Point(x, y, z);
    }
}
