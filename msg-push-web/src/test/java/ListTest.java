import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.event.annotation.PrepareTestInstance;

import java.awt.*;
import java.util.List;

class Rectangle implements Sharp {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }
}

public class ListTest {

    @Test
    public void testSize() {
        Integer expected = 100;
        List list = PowerMockito.mock(List.class);
        PowerMockito.when(list.size()).thenReturn(expected);
        Integer actual = list.size();
        Assert.assertEquals("返回值不相等", expected, actual);
    }

    @Test
    public void testGetArea() {
        double expected = 100.0D;
        Rectangle rectangle = PowerMockito.mock(Rectangle.class);
        PowerMockito.when(rectangle.getArea()).thenReturn(expected);
        double actual = rectangle.getArea();
        Assert.assertEquals("返回值不相等", expected, actual, 1E-6D);
    }

}
