import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotParamTest {

    private String expected;
    private int age;
    @ParameterizedTest
    @CsvSource({"10,Age ok", "20,Age ok", "25,Too old","10,Too old"})
    void testcheckageAll( int age, String expected)
    {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }

    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile.csv", numLinesToSkip = 1 )
    void testcheckageAll2( int age, String expected)
    {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }

    @ParameterizedTest
    @CsvSource({"5,10000.00f", "10,7500.00f","15,5000.00f","8,7500.00f","0,10000.00"})
    void testcheckCost(int age,float expected)
    {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost());
    }

}