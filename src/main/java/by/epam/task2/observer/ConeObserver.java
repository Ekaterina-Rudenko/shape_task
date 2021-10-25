package by.epam.task2.observer;

import by.epam.task2.exception.CustomException;

public interface ConeObserver {
    void updateConeParameters(ConeEvent coneEvent) throws CustomException;
    void updateSurfaceArea(ConeEvent coneEvent) throws CustomException;
    void updateVolume(ConeEvent coneEvent) throws CustomException;
}
