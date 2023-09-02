package pers.tony.bo;

import pers.tony.Constants;
import pers.tony.vo.Point;

public class ShapeFactory implements Constants {
    public static IShape createShape(String type, Point p1, Point p2) {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case LINE_FLAG:
                return new Line(p1, p2);
            case RECTANGLE_FLAG:
                return new Rectangle(p1, p2);
            default:
                throw new IllegalArgumentException("unknown type");
        }
    }
}
