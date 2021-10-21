package by.epam.task2.warehouse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, ConeParameter> coneMap;

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse() {
        this.coneMap = new HashMap<>();
    }

    public ConeParameter getCone(long coneId) {
        return coneMap.get(coneId);
    }

    public void putParameter(long coneId, ConeParameter value) {
        coneMap.put(coneId, value);
        logger.log(Level.INFO, "Cone " + coneId + " with parameters " + value + " was added");
    }

    public void removeParameter(long coneId) {
        coneMap.remove(coneId);
        logger.log(Level.INFO, " Cone " + coneId + " was removed");
    }

    public void putParameter(long coneId, double surfaceArea, double volume) {
        ConeParameter coneParameter = new ConeParameter();
        coneParameter.setSurfaceArea(surfaceArea);
        coneParameter.setVolume(volume);
        coneMap.put(coneId, coneParameter);
    }
}
