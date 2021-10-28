package by.epam.task2.warehouse;

import by.epam.task2.entity.Cone;
import by.epam.task2.exception.CustomException;

import java.util.List;

public interface WarehouseFiller {
    void fillWarehouse(Cone cone) throws CustomException;
    void fillWarehouse(List<Cone> coneList) throws CustomException;
}
