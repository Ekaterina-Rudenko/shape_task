package by.epam.task2.factory;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.CustomException;

import java.util.List;

public interface ConeFactory {
    Cone createCone(double[] coordinatesDouble) throws CustomException;

    Cone createCone(Point centre, Point apex, double radius) throws CustomException;

    Cone createCone(double centreX, double centreY, double centreZ, double apexX, double apexY, double apexZ, double radius) throws CustomException;

    List<Cone> createConeList(List<double[]> coneParameter) throws CustomException;
}
