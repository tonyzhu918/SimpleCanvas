package test.pers.tony.util;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.bo.Canvas;
import pers.tony.util.CheckUtil;
import pers.tony.vo.Point;

public class CheckUtilTest {
    @Test
    public void testSatisfyCollinear() {
        boolean check = CheckUtil.satisfyCollinear(new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertTrue(check);

        check = CheckUtil.satisfyCollinear(new Point(Canvas.MAX_WIDTH - 1, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertFalse(check);
    }

    @Test
    public void testSatisfyRectangle() {
        boolean check = CheckUtil.satisfyRectangle(new Point(Canvas.MAX_WIDTH - 2, Canvas.MAX_HEIGHT - 2), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertTrue(check);

        check = CheckUtil.satisfyRectangle(new Point(Canvas.MAX_WIDTH - 2, Canvas.MAX_HEIGHT), new Point(Canvas.MAX_WIDTH, Canvas.MAX_HEIGHT));
        Assert.assertFalse(check);
    }
}
