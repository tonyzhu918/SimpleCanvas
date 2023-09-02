package test.pers.tony.bo;

import org.junit.Test;
import pers.tony.bo.Canvas;
import pers.tony.vo.Point;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CanvasTest {
    @Test
    public void testCreateCanvas() {
        Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);

        try {
            Canvas.createCanvas(Canvas.MAX_WIDTH + 1, Canvas.MAX_HEIGHT);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT + 1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Canvas.createCanvas(Canvas.MIN_WIDTH - 1, Canvas.MAX_HEIGHT);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MIN_HEIGHT - 1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testSetPix() {
        Canvas canvas = Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        Point p = new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        canvas.setPix(p);
        canvas.draw();
        assertTrue(canvas.getPix(p));
    }

    @Test
    public void testCheckPos() {
        Canvas canvas = Canvas.createCanvas(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        Point p = new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT);
        try {
            canvas.checkPos(p);
        } catch (IllegalArgumentException ignored) {
            fail();
        }

        p = new Point(Canvas.MAX_WIDTH + 1, Canvas.MAX_HEIGHT);
        try {
            canvas.checkPos(p);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        p = new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT + 1);
        try {
            canvas.checkPos(p);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        p = new Point(0, Canvas.MAX_HEIGHT);
        try {
            canvas.checkPos(p);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        p = new Point(Canvas.MAX_WIDTH, 0);
        try {
            canvas.checkPos(p);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }
}
