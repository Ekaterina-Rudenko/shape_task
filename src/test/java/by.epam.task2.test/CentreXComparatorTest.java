package by.epam.task2.test;

import by.epam.task2.comparator.CentreXComparator;
import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import by.epam.task2.repository.Repository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CentreXComparatorTest {
    Repository repository = Repository.getInstance();
    CentreXComparator comparator = new CentreXComparator();
    ArrayList<Cone> cones;
    @BeforeMethod
    public void setUp(){
        cones = new ArrayList<>();
        cones.add(new Cone(new Point(1.0, 2.0, 1.0), new Point(1.0, 2.0, 5.0), 4.0));
        cones.add(new Cone(new Point(1.0, 3.0, 1.0), new Point(1.0, 2.0, 5.0), 4.0));
        cones.add(new Cone(new Point(3.0, 1.0, 1.0), new Point(1.0, 2.0, 5.0), 4.0));
    }
    @Test
    public void centreXComparatorTest(){
        int actual = comparator.compare(cones.get(0), cones.get(1));
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void centreXComparatorDifferentTest(){
        int actual = comparator.compare(cones.get(1), cones.get(2));
        int expected = -1;
        Assert.assertEquals(actual, expected);
    }

}
