package by.epam.task2.entity;

import by.epam.task2.exception.CustomException;
import by.epam.task2.generator.IdGenerator;
import by.epam.task2.observer.ConeEvent;
import by.epam.task2.observer.ConeObserver;
import by.epam.task2.observer.Observable;
import by.epam.task2.observer.impl.ConeConeObserverImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cone implements Observable {
    static Logger logger = LogManager.getLogger();
    private long coneId;
    private Point centrePoint;
    private Point apexPoint;
    private double radius;
    private List<ConeObserver> observers = new ArrayList<>();

    public Cone(Point centerPoint, Point apexPoint, double radius) {
        this.coneId = IdGenerator.generateId();
        this.centrePoint = centerPoint;
        this.apexPoint = apexPoint;
        this.radius = radius;
    }

    public long getConeId() {
        return coneId;
    }

    public void setConeID(long coneId) {
        this.coneId = coneId;
        notifyObservers();
    }

    public Point getCentrePoint() {
        return centrePoint;
    }

    public void setCentrePoint(Point centrePoint) throws CustomException {
        if (centrePoint == null) {
            throw new CustomException("Can't set null point");
        }
        this.centrePoint = centrePoint;
        notifyObservers();
    }

    public Point getApexPoint() {
        return apexPoint;
    }

    public void setApexPoint(Point apexPoint) throws CustomException {
        if (apexPoint == null) {
            throw new CustomException("Can't set null point");
        }
        this.apexPoint = apexPoint;
        notifyObservers();
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
        notifyObservers();
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
                && centrePoint.equals(cone.centrePoint)
                && apexPoint.equals(cone.apexPoint);
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int result = centrePoint != null ? centrePoint.hashCode() : 0;
        result = prime * result + apexPoint.hashCode();
        result = prime * result + Double.hashCode(radius);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(coneId);
        sb.append(", centerPoint=").append(centrePoint);
        sb.append(", apexPoint=").append(apexPoint);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public void attach(ConeObserver observer){
        observers.add(observer);
    }
    @Override
    public void detach(ConeObserver observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() throws CustomException {
        ConeEvent coneEvent = new ConeEvent(this);
        if(!observers.isEmpty()){
            for(ConeObserver observer : observers){
                observer.updateSurfaceArea(coneEvent);
                observer.updateVolume(coneEvent);
            }
        }
    }
}

