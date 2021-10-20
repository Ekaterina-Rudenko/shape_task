package by.epam.task2.parser.impl;

import by.epam.task2.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.task2.parser.ConeParser;
import by.epam.task2.validator.ConeValidator;
import by.epam.task2.validator.impl.ConeValidatorImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConeParserImpl implements ConeParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public Optional<double[]> parseParameter(String parameterLine) throws CustomException {
        ConeValidator validator = ConeValidatorImpl.getInstance();
        if (parameterLine == null) {
            logger.log(Level.ERROR, "The line for parsing is null");
            throw new CustomException("The line for parsing is null");
        }
        String[] readyToParse = Stream.of(parameterLine)
                .filter(validator::checkConeString)
                .toString()
                .split(DELIMITER_SPACE);

        double[] coneParameterArray = Stream.of(readyToParse)
                .mapToDouble(Double::parseDouble)
                .toArray();
        return Optional.ofNullable(coneParameterArray);
    }

    @Override
    public List<double[]> parseParameterToList(List<String> parameterLineList) throws CustomException {
        ConeValidator validator = ConeValidatorImpl.getInstance();
        if (parameterLineList == null) {
            logger.log(Level.ERROR, "The line for parsing is null");
            throw new CustomException("The line for parsing is null");
        }
        List<double[]> parameterArrayList = parameterLineList.stream()
                .filter(validator::checkConeString)
                .map(e -> Stream.of(e.split(DELIMITER_SPACE))
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .toList();
        if (parameterArrayList.isEmpty()) {
            logger.log(Level.ERROR, "No valid data to parse");
            throw new CustomException("There is no valid lines to parse");
        }
        return parameterArrayList;
    }
}
