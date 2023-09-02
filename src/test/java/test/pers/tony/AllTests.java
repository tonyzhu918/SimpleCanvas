package test.pers.tony;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.pers.tony.bo.CanvasTest;
import test.pers.tony.bo.LineTest;
import test.pers.tony.bo.RectangleTest;
import test.pers.tony.bo.ShapeFactoryTest;
import test.pers.tony.util.CheckUtilTest;
import test.pers.tony.util.ParseUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CanvasTest.class,
        LineTest.class,
        RectangleTest.class,
        ShapeFactoryTest.class,
        CheckUtilTest.class,
        ParseUtilTest.class,
        SimpleCanvasTest.class,
})
public class AllTests {
}
