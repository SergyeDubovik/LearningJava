package lessons;

import com.objects.geometry.Point;

public class Lesson4 {
    public static void main(String[] args) {
        Point a = new Point(1.5, 2.7);
        Point b = new Point(3.2, 4.1);
//        System.out.println(isRighter(a, b));
//        System.out.println(isRighter(b, a));

        Point c = new Point(2.2, 0.);
        Point d = new Point(2.2, 2.9);
        System.out.println(isHigher(c, d));
        System.out.println(isHigher(d, c));


        System.out.println(distance(c, d));

        System.out.println(c.isRighter(b));
        System.out.println(b.isRighter(c));

        System.out.println(c.isHigher(d));
        System.out.println(d.isHigher(c));

        System.out.println(c.distance(d));


    }

    public static boolean isRighter(Point a, Point b) {
        return a.x > b.x;
    }

    /*
        1 написать похожий метод, который будет проверять выше точка, или ниже
        */

    public static boolean isHigher(Point c, Point d) {
        return c.y > d.y;
    }
    /*
        2 написать метод, который определяет расстояние между двумя точками
     */

    public static double distance(Point c, Point d) {
        double length;
        length = Math.sqrt(Math.pow(c.x - d.x, 2) + Math.pow(c.y - d.y, 2));

        return length;
    }
}
