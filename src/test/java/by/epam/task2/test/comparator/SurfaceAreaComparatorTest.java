package by.epam.task2.test.comparator;

import by.epam.task2.comparator.SurfaceAreaComparator;
import by.epam.task2.entity.Cone;
import by.epam.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SurfaceAreaComparatorTest {
    SurfaceAreaComparator comparator;

    @BeforeMethod
    public void create() {
        comparator = new SurfaceAreaComparator();
    }

    @DataProvider(name = "conesToCompare")
    public Object[][] coneData() {
        List<Cone> coneList = new ArrayList<>();
        coneList.add(new Cone(new Point(1.0, 2.0, 1.0), new Point(1.0, 2.0, 5.0), 4.0));
        coneList.add(new Cone(new Point(1.0, 2.0, 1.0), new Point(1.0, 2.0, 5.0), 4.0));
        coneList.add(new Cone(new Point(1.0, 2.0, 1.0), new Point(1.0, 2.0, 5.0), -4.1));
        coneList.add(new Cone(new Point(3.0, 4.0, -5.0), new Point(3.0, 4.0, 10.0), 14.0));
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(-1);
        return new Object[][]{{coneList, expected}};
    }

    @Test(dataProvider = "conesToCompare")
    public void centreXComparatorEqualTest(List<Cone> cone, List<Integer> expected) {
        int actual = comparator.compare(cone.get(0), cone.get(1));
        Assert.assertEquals(actual, (int) expected.get(0));
    }

    @Test(dataProvider = "conesToCompare")
    public void centreXComparatorTest(List<Cone> cone, List<Integer> expected) {
        int actual = comparator.compare(cone.get(0), cone.get(2));
        Assert.assertEquals(actual, (int) expected.get(1));
    }
    @Test(dataProvider = "conesToCompare")
    public void centreXComparatorDifferentTest(List<Cone> cone, List<Integer> expected) {
        int actual = comparator.compare(cone.get(0), cone.get(3));
        Assert.assertEquals(actual, (int) expected.get(2));
    }
}
