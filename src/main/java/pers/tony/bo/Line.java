package pers.tony.bo;

import pers.tony.util.CheckUtil;
import pers.tony.vo.Point;

public class Line extends Shape {
    public Line(Point p1, Point p2) {
        super.p1 = p1;
        super.p2 = p2;
    }

    @Override
    public void fill(Canvas canvas) {
        checkInputAndBoundary(p1, p2, canvas);
        // controls the logic of filling specific pixes
        if (p1.getX() == p2.getX()) {
            for (int i = p1.getY(); i <= p2.getY(); i++)
                canvas.setPix(new Point(p1.getX(), i));
        } else {
            for (int i = p1.getX(); i <= p2.getX(); i++)
                canvas.setPix(new Point(i, p1.getY()));
        }
    }

    private void checkInputAndBoundary(Point p1, Point p2, Canvas canvas) throws IllegalArgumentException {
        if (!CheckUtil.satisfyCollinear(p1, p2)) throw new IllegalArgumentException(INVALID_PARAM_MSG);
        canvas.checkPos(p1);
        canvas.checkPos(p2);
    }


}
