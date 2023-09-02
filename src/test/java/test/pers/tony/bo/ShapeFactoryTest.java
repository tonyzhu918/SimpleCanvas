package test.pers.tony.bo;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.Constants;
import pers.tony.bo.Canvas;
import pers.tony.bo.IShape;
import pers.tony.bo.ShapeFactory;
import pers.tony.vo.Point;

import static org.junit.Assert.fail;

public class ShapeFactoryTest implements Constants {
    @Test
    public void testCreateShape() {
        IShape shape = ShapeFactory.createShape(LINE_FLAG, new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertNotNull(shape);

        shape = ShapeFactory.createShape(RECTANGLE_FLAG, new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertNotNull(shape);

        shape = ShapeFactory.createShape("", new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertNull(shape);

        try {
            ShapeFactory.createShape("a", new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
            fail();
        } catch (Exception ignored) {
        }
    }
}
