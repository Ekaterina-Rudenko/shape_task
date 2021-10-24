package by.epam.task2.parser;

import by.epam.task2.exception.CustomException;

import java.util.List;

public interface ConeParser {
    String DELIMITER_SPACE = "\\s+";

    double[] parseParameter(String parameterLine) throws CustomException;

    List<double[]> parseParameterToList(List<String> parameterLineList) throws CustomException;
}
