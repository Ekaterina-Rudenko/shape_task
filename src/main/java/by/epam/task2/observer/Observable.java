package by.epam.task2.observer;

import by.epam.task2.exception.CustomException;

public interface Observable {
    void attach(ConeObserver observer);
    void detach(ConeObserver observer);
    void notifyObservers() throws CustomException;
}
