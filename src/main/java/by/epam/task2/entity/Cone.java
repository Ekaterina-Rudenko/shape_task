package by.epam.task2.entity;

import by.epam.task2.generator.IdGenerator;

import java.util.Objects;
import java.util.StringJoiner;

public class Cone {
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

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Point getApexPoint() {
        return apexPoint;
    }

    public void setApexPoint(Point apexPoint) {
        this.apexPoint = apexPoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return coneId == cone.coneId
                && Double.compare(cone.radius, radius) == 0
                && centerPoint.equals(cone.centerPoint)
                && apexPoint.equals(cone.apexPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coneId, centerPoint, apexPoint, radius);
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

