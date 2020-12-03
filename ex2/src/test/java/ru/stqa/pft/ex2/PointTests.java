package ru.stqa.pft.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(5,5);
        Point p2 = new Point(2,1);

        Point p3 = new Point(1,1);
        Assert.assertEquals(p3.distance(p1,p2), 5);
    }
}
