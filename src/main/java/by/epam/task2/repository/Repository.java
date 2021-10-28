package by.epam.task2.repository;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    static Logger logger = LogManager.getLogger();
    private static Repository instance;
    private List<Cone> cones;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
        cones = new ArrayList<>();
    }


    public Optional<Cone> get(int index) throws CustomException {
        if(index >= size() || index < 0){
            logger.log(Level.ERROR, "Index " + index + " is out of bounds for repository size " + size());
            throw new CustomException("Index " + index + " is out of bounds for repository size " + size());
        }
        Cone cone = cones.get(index);
        return Optional.ofNullable(cone);
    }

    public List<Cone> getCones() {
        return Collections.unmodifiableList(cones);
    }

    public int size() {
        return cones.size();
    }

    public void setCone(int index, Cone cone) throws CustomException {
        if(index >= size() || index < 0){
            logger.log(Level.ERROR, "Index " + index + " is out of bounds for repository size " + size());
            throw new CustomException("Index " + index + " is out of bounds for repository size " + size());
        }
        cones.set(index, cone);
    }

    public boolean add(Cone cone) {
        boolean isAdded = false;
        if (!cones.contains(cone)) {
            isAdded = cones.add(cone);
        }
        return isAdded;
    }

    public boolean addAll(Collection<? extends Cone> c) {
        boolean isAdded = false;
        if (!cones.contains(c)) {
            isAdded = cones.addAll(c);
        }
        logger.log(Level.INFO, "Cones were added to repository " + isAdded);
        return isAdded;
    }

    public boolean remove(Cone cone) {
        return cones.remove(cone);
    }

    public Cone remove(int index) {
        return cones.remove(index);
    }

    public boolean removeAll(Collection<Cone> c) {
        return cones.removeAll(c);
    }

    public List<Cone> query(Specification specification) {
        List<Cone> result = cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "\nQuery " + specification.getClass().getSimpleName() + " result is : " + result);
        return result;
    }

    public void sortCone(Comparator<? super Cone> comparator) {
        List<Cone> result = cones.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "\nSorted with comparator " + comparator.getClass().getSimpleName() + " : " + result);
    }
}
