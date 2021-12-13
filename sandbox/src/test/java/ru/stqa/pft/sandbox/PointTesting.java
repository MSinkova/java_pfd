package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pfd.sandbox.Point;

public class PointTesting {

    @Test
    public void testPoint() {
        Point p1 = new Point(5, 34);
        Point p2 = new Point (3, 45);
        Assert.assertEquals(p1.distance(p2),11.180339887498949);
    }
}
