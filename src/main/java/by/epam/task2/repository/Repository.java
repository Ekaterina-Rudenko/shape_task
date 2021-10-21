package by.epam.task2.repository;

import by.epam.task2.entity.Cone;
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

    public List<Cone> getCones() {
        List<Cone> cones = new ArrayList<>();
        return cones;
    }

    public Optional<Cone> get(int index) {
        Cone cone = cones.get(index);
        return Optional.ofNullable(cone);
    }


    public void setCone(int index, Cone cone) {
        cones.set(index, cone);
    }

    public boolean add(Cone cone) {
        return cones.add(cone);
    }

    public boolean addAll(Collection<? extends Cone> c) {
        return cones.addAll(c);
    }

    public boolean remove(Cone cone) {
        return cones.remove(cone);
    }

    public boolean removeAll(Collection<Cone> c) {
        return cones.removeAll(c);
    }

    public List<Cone> query(Specification specification) {
        List<Cone> result = cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return result;
    }

    public void sortCone(Comparator<? super Cone> comparator) {
        List<Cone> result = cones.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        logger.log(Level.INFO, "Sorted with comparator " + comparator + " : " + result);
    }
}
