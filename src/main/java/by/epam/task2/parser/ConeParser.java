package by.epam.task2.parser;

import java.util.List;

public interface ConeParser {
    String DELIMITER_SPACE = "\\s+";

    List<double[]> parseParameterToList(List<String> parameterLineList);
}
