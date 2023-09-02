package test.pers.tony;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.SimpleCanvas;
import pers.tony.util.ParseUtil;
import pers.tony.vo.LineCommand;
import pers.tony.vo.Point;

import static org.junit.Assert.fail;

public class SimpleCanvasTest extends SimpleCanvas {
    @Test
    public void testProcessCommand() {
        LineCommand lineCommand = ParseUtil.parseLineCommand("L 1 2 6 2");
        try {
            processCommand(lineCommand);
            fail();
        } catch (Exception ignored) {
        }

        lineCommand = ParseUtil.parseLineCommand("R 16 1 20 3");
        try {
            processCommand(lineCommand);
            fail();
        } catch (Exception ignored) {
        }

        lineCommand = ParseUtil.parseLineCommand("C 20 4");
        processCommand(lineCommand);

        lineCommand = ParseUtil.parseLineCommand("L 1 2 6 2");
        processCommand(lineCommand);

        lineCommand = ParseUtil.parseLineCommand("R 16 1 20 3");
        processCommand(lineCommand);

        Assert.assertTrue(canvas.getPix(new Point(1, 2)));
        Assert.assertTrue(canvas.getPix(new Point(2, 2)));

        Assert.assertTrue(canvas.getPix(new Point(17, 1)));
        Assert.assertTrue(canvas.getPix(new Point(18, 3)));
    }

    @Test
    public void testGetUsage() {
        String usage = SimpleCanvas.getUsage();
        Assert.assertTrue(usage.contains("to create a new canvas"));
    }
}
