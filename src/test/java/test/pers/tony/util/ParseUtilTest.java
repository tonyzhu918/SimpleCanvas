package test.pers.tony.util;

import org.junit.Assert;
import org.junit.Test;
import pers.tony.Constants;
import pers.tony.util.ParseUtil;
import pers.tony.vo.LineCommand;

import static org.junit.Assert.fail;

public class ParseUtilTest implements Constants {
    @Test
    public void testParseLineCommand() {
        LineCommand lineCommand = ParseUtil.parseLineCommand("C 20 4");
        Assert.assertEquals(CREATE_CANVAS_FLAG, lineCommand.getCommand());
        Assert.assertEquals(20, lineCommand.getParam(0));

        try {
            ParseUtil.parseLineCommand("C X 4");
            fail();
        } catch (Exception ignored) {
        }

        lineCommand = ParseUtil.parseLineCommand("L 1 2 6 2");
        Assert.assertEquals(LINE_FLAG, lineCommand.getCommand());
        Assert.assertEquals(2, lineCommand.getParam(1));

        try {
            ParseUtil.parseLineCommand("L 1 Y 6 2");
            fail();
        } catch (Exception ignored) {
        }

        lineCommand = ParseUtil.parseLineCommand("R 16 1 20 3");
        Assert.assertEquals(RECTANGLE_FLAG, lineCommand.getCommand());
        Assert.assertEquals(20, lineCommand.getParam(2));

        try {
            ParseUtil.parseLineCommand("R 16 1 20");
            fail();
        } catch (Exception ignored) {
        }

        try {
            ParseUtil.parseLineCommand("R 16 1 Z 3");
            fail();
        } catch (Exception ignored) {
        }

        lineCommand = ParseUtil.parseLineCommand("Q 16 1 20 3");
        Assert.assertEquals(QUIT_FLAG, lineCommand.getCommand());

        try {
            ParseUtil.parseLineCommand("A 16 1 20 3");
            fail();
        } catch (Exception ignored) {
        }
    }
}
