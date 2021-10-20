package by.epam.task2.factory.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.factory.PointFactory;

public class PointFactoryImpl implements PointFactory {
    @Override
    public Point createPoint(double x, double y, double z){
        return new Point(x, y, z);
    }
}
