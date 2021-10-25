package by.epam.task2.warehouse;

import by.epam.task2.entity.Cone;
import by.epam.task2.entity.ConeParameter;
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

    public ConeParameter getConeParameter(Cone cone) {
        return coneMap.get(cone);
    }

    public void putParameter(long coneId, ConeParameter value) {
        coneMap.put(coneId, value);
        logger.log(Level.INFO, "Cone " + coneId + " parameters " + value + " were added to warehouse");
    }

    public void removeParameter(long coneId) {
        coneMap.remove(coneId);
        logger.log(Level.INFO, " Cone " + coneId + " was removed from warehouse");
    }
}
