package test.pers.tony.bo;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.bo.Canvas;
import pers.tony.bo.Line;
import pers.tony.vo.Point;

public class LineTest {
    @Test
    public void testFill() {
        Canvas canvas = Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        Line line = new Line(new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT-2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        line.fill(canvas);
        Assert.assertTrue(canvas.getPix(new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 1)));

        line = new Line(new Point(Canvas.MAX_WIDTH-2, Canvas.MAX_HEIGHT-3), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT-3));
        line.fill(canvas);
        Assert.assertTrue(canvas.getPix(new Point(Canvas.MAX_WIDTH-2, Canvas.MAX_HEIGHT - 3)));
    }
}
