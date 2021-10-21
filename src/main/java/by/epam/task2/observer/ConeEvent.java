package by.epam.task2.observer;

import by.epam.task2.entity.Cone;
import java.util.EventObject;

public class ConeEvent extends EventObject {
    public ConeEvent(Cone source) {
        super(source);
    }
    @Override
    public Cone getSource(){
        return (Cone) super.getSource();
    }
}
