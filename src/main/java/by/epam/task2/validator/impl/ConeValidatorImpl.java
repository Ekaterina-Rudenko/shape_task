package by.epam.task2.validator.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.validator.ConeValidator;

public class ConeValidatorImpl implements ConeValidator {
    private static ConeValidatorImpl instance;

    private ConeValidatorImpl() {
    }

    public static ConeValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ConeValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean isCone(double... parameter) {
        boolean isValidSize = (parameter.length == NUMBER_OF_CONE_PARAMETERS);
        boolean isValidParameter = false;
        if(isValidSize){
        isValidParameter = (Double.compare(parameter[INDEX_CENTRE_X], parameter[INDEX_APEX_X]) == 0
                && Double.compare(parameter[INDEX_CENTRE_Y], parameter[INDEX_APEX_Y]) == 0
                && Double.compare(parameter[INDEX_CENTRE_Z], parameter[INDEX_APEX_Z]) != 0
                && parameter[INDEX_RADIUS] > 0);}
        return (isValidSize && isValidParameter);
    }

    @Override
    public boolean isCone(Cone cone) {
        Point centre = cone.getCentrePoint();
        Point apex = cone.getApexPoint();
        double radius = cone.getRadius();
        return checkParameter(centre, apex, radius);
    }

    @Override
    public boolean isCone(Point centre, Point apex, double radius) {
        return checkParameter(centre, apex, radius);
    }

    private boolean checkParameter(Point centre, Point apex, double radius) {
        boolean isValid = (centre != null && apex != null
                && Double.compare(centre.getX(), apex.getX()) == 0
                && Double.compare(centre.getY(), apex.getY()) == 0
                && Double.compare(centre.getZ(), apex.getZ()) != 0
                && radius > 0);
        return isValid;
    }

    @Override
    public boolean checkDissectionHeight(Cone cone, double height) {
        double centre = cone.getCentrePoint().getZ();
        double apex = cone.getApexPoint().getZ();
        boolean isValid = (apex > centre && height >= centre && height <= apex) ||
                (apex < centre && height <= centre && height >= apex);
        return isValid;
    }
}
