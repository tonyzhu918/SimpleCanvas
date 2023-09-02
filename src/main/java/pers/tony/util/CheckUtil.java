package pers.tony.util;

import pers.tony.vo.Point;

public class CheckUtil {
    public static boolean satisfyCollinear(Point p1, Point p2) {
        //make sure p1 is left or upper to p2 and with same x or y axis
        if (p1.equals(p2)) return false;

        if (p1.getX() > p2.getX() || p1.getY() > p2.getY()) return false;

        return p1.getX() == p2.getX() || p1.getY() == p2.getY();

    }

    public static boolean satisfyRectangle(Point p1, Point p2) {
        //make sure p1 is left and upper to p2
        return p1.getX() < p2.getX() && p1.getY() < p2.getY();

    }
}
