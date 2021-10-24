package by.epam.task2.validator.impl;

import by.epam.task2.validator.ConeStringValidator;

public class ConeStringValidatorImpl implements ConeStringValidator {
    private static ConeStringValidatorImpl instance;

    private ConeStringValidatorImpl() {
    }

    public static ConeStringValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ConeStringValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean checkConeString(String coneDataLine) {
        return coneDataLine.matches(VALID_CONE_STRING);
    }
}
