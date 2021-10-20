package by.epam.task2.reader;

import by.epam.task2.exception.CustomException;
import java.util.List;

public interface InfoReader {
    List<String> readConesFromFile(String filePath) throws CustomException;
}
