package by.epam.task2.main;

import by.epam.task2.exception.CustomException;
import by.epam.task2.reader.impl.InfoReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();
    private final static String DEFAULT_FILE_PATH = "data/info.txt";
    public static void main(String[] args) throws CustomException {
        InfoReaderImpl reader = new InfoReaderImpl();
        List<String> conesList = reader.readConesFromFile(DEFAULT_FILE_PATH);
        System.out.println(conesList.toString());

    }
}
