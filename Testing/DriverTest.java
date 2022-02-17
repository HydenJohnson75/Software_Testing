import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    public void testSetDriverNumMethod() throws Exception
    {
        System.out.println("setDriverNumMethod");
        Driver target = new Driver("robbie", 200);

        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

        method.setAccessible(true);

        method.invoke(target, 300);

        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("driverNum");

        f.setAccessible(true);

        int result = f.getInt(target); System.out.println("The value in f (driverNum) is " + f.get(target)); assertEquals( 300, result);

    }
}

