package ru.stqa.pfd.sandbox;

import ru.stqa.pfd.sandbox.Point;

public class PointTest {
    public static void main (String[] arg) {

        Point p1 = new Point(22, 5);
        Point p2 = new Point(11, 98);
        System.out.println( "Расстояние между точками = " + p1.distance(p2));
    }
}
