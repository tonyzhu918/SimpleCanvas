package pers.tony.bo;

import pers.tony.util.CheckUtil;
import pers.tony.vo.Point;

public class Rectangle extends Shape {
    public Rectangle(Point p1, Point p2) {
        super.p1 = p1;
        super.p2 = p2;
    }

    @Override
    public void fill(Canvas canvas) {
        checkInputAndBoundary(p1, p2, canvas);
        // controls the logic of filling specific pixes
        for (int i = p1.getX(); i <= p2.getX(); i++) {
            canvas.setPix(new Point(i, p1.getY()));
            canvas.setPix(new Point(i, p2.getY()));
        }
        for (int i = p1.getY() + 1; i <= p2.getY() - 1; i++) {
            canvas.setPix(new Point(p1.getX(), i));
            canvas.setPix(new Point(p2.getX(), i));
        }
    }

    private void checkInputAndBoundary(Point p1, Point p2, Canvas canvas) throws IllegalArgumentException {
        if (!CheckUtil.satisfyRectangle(p1, p2)) throw new IllegalArgumentException(INVALID_PARAM_MSG);
        canvas.checkPos(p1);
        canvas.checkPos(p2);
    }
}
