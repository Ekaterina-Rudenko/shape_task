package by.epam.task2.warehouse;

import java.util.StringJoiner;

public class ConeParameter {
    private double surfaceArea;
    private double volume;
    public ConeParameter(){}
    public ConeParameter(double surfaceArea, double volume){
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConeParameter that = (ConeParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)surfaceArea;
        result = prime * result + (int)volume;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConeParameter.class.getSimpleName() + "[", "]")
                .add("surfaceArea=" + surfaceArea)
                .add("volume=" + volume)
                .toString();
    }
}
