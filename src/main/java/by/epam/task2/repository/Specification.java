package by.epam.task2.repository;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;

public interface Specification {
    boolean specify(Cone cone) throws CustomException;
}
