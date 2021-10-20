package by.epam.task2.entity;

import by.epam.task2.exception.CustomException;
import by.epam.task2.generator.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cone {
    static Logger logger = LogManager.getLogger();
    private long coneId;
    private Point centerPoint;
    private Point apexPoint;
    private double radius;

    public Cone(Point centerPoint, Point apexPoint, double radius) {
        this.coneId = IdGenerator.generateId();
        this.centerPoint = centerPoint;
        this.apexPoint = apexPoint;
        this.radius = radius;
    }

    public long getConeID() {
        return coneId;
    }

    public void setConeID(long coneID) {
        this.coneId = coneID;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) throws CustomException {
        if (centerPoint == null) {
            throw new CustomException("Can't set null point");
        }
        this.centerPoint = centerPoint;
    }

    public Point getApexPoint() {
        return apexPoint;
    }

    public void setApexPoint(Point apexPoint) throws CustomException {
        if (apexPoint == null) {
            throw new CustomException("Can't set null point");
        }
        this.apexPoint = apexPoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws CustomException {
        if (radius < 0) {
            logger.log(Level.ERROR, "The radius " + radius + "can't be set, radius must be positive value");
            throw new CustomException("The radius " + radius + " can't be set");
        }
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cone cone = (Cone) o;
        return coneId == cone.coneId
                && Double.compare(cone.radius, radius) == 0
                && centerPoint.equals(cone.centerPoint)
                && apexPoint.equals(cone.apexPoint);
    }

    @Override
    public int hashCode() {
        int result = centerPoint != null ? centerPoint.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(coneId);
        sb.append(", centerPoint=").append(centerPoint);
        sb.append(", apexPoint=").append(apexPoint);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}

