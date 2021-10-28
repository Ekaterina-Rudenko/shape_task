package by.epam.task2.service;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;

import java.util.OptionalDouble;

public interface ConeCalculation {
    double findSurfaceArea(Cone cone) throws CustomException;

    double findVolume(Cone cone) throws CustomException;

    double dissectionVolumeRatio(Cone cone, double dissectionHeight) throws CustomException;

    boolean isBaseOnPlane(Cone cone);

    OptionalDouble averageSurfaceArea();

    OptionalDouble averageVolume();

}
