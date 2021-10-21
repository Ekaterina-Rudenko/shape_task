package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cone;
import by.epam.task2.repository.Specification;

public class IdSpecification implements Specification {
    private long coneId;
    public IdSpecification(long coneId){
        this.coneId = coneId;
    }
    @Override
    public boolean specify(Cone cone){
      return (cone.getConeId() == coneId);
    }
}
