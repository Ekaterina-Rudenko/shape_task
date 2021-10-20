package by.epam.task2.service;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;

public interface ConeCalculation {
    double findSurfaceArea(Cone cone);

    double findVolume(Cone cone);

    double dissectionVolumeRatio(Cone cone, double dissectionHeight) throws CustomException;

    boolean isBaseOnPlane(Cone cone);

}
