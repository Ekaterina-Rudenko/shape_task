package by.epam.task2.reader.impl;

import by.epam.task2.exception.CustomException;
import by.epam.task2.reader.InfoReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InfoReaderImpl implements InfoReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readConesFromFile(String filePath) throws CustomException {
        List<String> parametersList = new ArrayList<>();
        try {
            Files.lines(Paths.get(filePath))
                    .forEach(parametersList::add);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Reading from " + filePath + " was failed or interrupted", e);
            throw new CustomException("Reading from " + filePath + " was failed or interrupted", e);
        }

        return parametersList;
    }
}
