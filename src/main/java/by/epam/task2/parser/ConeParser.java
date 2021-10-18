package by.epam.task2.parser;

import by.epam.task2.exception.CustomException;

import java.util.List;
import java.util.Optional;

public interface ConeParser {
    static final String DELIMITER_SPACE = "\\s+";
    Optional<double[]> parseParameter(String parameterLine) throws CustomException;
    List<double[]> parseParameterToList(List<String> parameterLineList) throws CustomException;
}
