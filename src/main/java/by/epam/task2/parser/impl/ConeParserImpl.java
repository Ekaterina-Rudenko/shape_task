package by.epam.task2.parser.impl;

import by.epam.task2.validator.ConeStringValidator;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeStringValidatorImpl;
import by.epam.task2.validator.impl.ConeValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.task2.parser.ConeParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ConeParserImpl implements ConeParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<double[]> parseParameterToList(List<String> parameterLineList) {
        ConeStringValidator validator = ConeStringValidatorImpl.getInstance();
        ConeValidator coneValidator = ConeValidatorImpl.getInstance();
        List<double[]> parameterArrayList = new ArrayList<>();
        if (parameterLineList != null) {
            parameterArrayList = parameterLineList.stream()
                    .filter(validator::checkConeString)
                    .map(e -> Stream.of(e.split(DELIMITER_SPACE))
                            .mapToDouble(Double::parseDouble)
                            .toArray())
                    .filter(coneValidator::isCone)
                    .toList();
        }
        if (parameterArrayList.isEmpty()) {
            logger.log(Level.INFO, "No valid data to parse, the empty list is returned");
        }
        return parameterArrayList;
    }
}
