package test.pers.tony.bo;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.bo.Canvas;
import pers.tony.bo.Rectangle;
import pers.tony.vo.Point;

import static org.junit.Assert.fail;

public class RectangleTest {
    @Test
    public void testFill() {
        Canvas canvas = Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        Rectangle rectangle = new Rectangle(new Point(Canvas.MAX_WIDTH - 2, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        rectangle.fill(canvas);
        Assert.assertTrue(canvas.getPix(new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2)));

        try {
            rectangle = new Rectangle(new Point(Canvas.MAX_WIDTH - 2, Canvas.MAX_HEIGHT - 3), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 3));
            rectangle.fill(canvas);
            fail();
        } catch (Exception ignored) {
        }
    }
}
