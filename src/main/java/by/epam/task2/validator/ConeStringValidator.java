package by.epam.task2.validator;

public interface ConeStringValidator {
    String VALID_CONE_STRING = "([+-]?\\d+((\\.\\d+)|\\.)?\\s+){6}[+]?\\d+((\\.\\d+)|\\.)?(\\s+)?";
    boolean checkConeString(String coneDataLine);
}
