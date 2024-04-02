package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Circle.class})
public class CircleTest {

    @Test
    public void testGetArea() {
        double excepted = 3.14D;
        Circle circle = PowerMockito.mock(Circle.class);
        PowerMockito.when(circle.getArea()).thenReturn(excepted);
        double actualArea = circle.getArea();
        Assert.assertEquals("返回值不相等", excepted, actualArea, 1e-6d);
    }
}
