public class PointTest {
    public static void main (String[] arg) {

        Point p1 = new Point();
        Point p2 = new Point();

        p1.x = 12;
        p1.y = 22;
        p2.x = 9;
        p2.y = 34;

        System.out.println( "Расстояние между точками = " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}
