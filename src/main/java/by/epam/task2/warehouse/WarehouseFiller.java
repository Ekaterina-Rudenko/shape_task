package by.epam.task2.warehouse;

import by.epam.task2.entity.Cone;

import java.util.List;

public interface WarehouseFiller {
    void fillWarehouse(Cone cone);
    void fillWarehouse(List<Cone> coneList);
}
