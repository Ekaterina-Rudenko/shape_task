package by.epam.task2.validator;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;

public interface ConeValidator {
    int NUMBER_OF_CONE_PARAMETERS = 7;
    String VALID_CONE_STRING = "([+-]?\\d+((\\.\\d+)|\\.)?\\s){6}[+]?\\d+((\\.\\d+)|\\.)?";
    int INDEX_CENTRE_X = 0;
    int INDEX_CENTRE_Y = 1;
    int INDEX_CENTRE_Z = 2;
    int INDEX_APEX_X = 3;
    int INDEX_APEX_Y = 4;
    int INDEX_APEX_Z = 5;
    int INDEX_RADIUS = 6;

    boolean checkConeString(String coneDataLine);

    boolean isCone(double... parameter);

    boolean isCone(Cone cone);

    boolean isCone(Point centre, Point apex, double radius);

    boolean checkDissectionHeight(Cone cone, double height);

}
