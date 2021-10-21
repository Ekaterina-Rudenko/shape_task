package by.epam.task2.repository;

import by.epam.task2.entity.Cone;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {
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
        List<Cone> result = new ArrayList<>();
        result = cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return result;
    }

    public void sortCone(Comparator<? super Cone> comparator) {
        cones.stream()
                .sorted(comparator);
    }
}
