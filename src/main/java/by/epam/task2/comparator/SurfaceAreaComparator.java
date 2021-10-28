package by.epam.task2.comparator;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import by.epam.task2.service.ConeCalculation;
import by.epam.task2.service.impl.ConeCalculationImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SurfaceAreaComparator implements Comparator<Cone> {
    static Logger logger = LogManager.getLogger();
    public int compare(Cone cone1, Cone cone2) {
        ConeCalculation calculation = new ConeCalculationImpl();
        double surfaceArea1 = 0;
        double surfaceArea2 = 0;
        try {
            surfaceArea1 = calculation.findSurfaceArea(cone1);
            surfaceArea2 = calculation.findSurfaceArea(cone2);
        } catch (CustomException e) {
            logger.log(Level.INFO, "Exception can't be generated here", e);
        }
        return Double.compare(surfaceArea1, surfaceArea2);
    }
}
