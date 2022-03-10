import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @BeforeEach /* for console output testing */
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testNumberOkMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver John = new Driver("John", 3000);
        John.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
        assertEquals("Driver number valid", linesOfOutput[0]);

    }

    @Test
    public void testNumberNotOkMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver John = new Driver("John", 6000);
        John.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
        assertEquals("Error Driver number not valid", linesOfOutput[0]);

    }
}

