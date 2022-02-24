import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import static java.time.Duration.ofMillis;

// change the lifecycle

@TestInstance
        (TestInstance.Lifecycle.PER_CLASS)


class RobotLifeCycleTest {
    /* Robot buddy = new Robot("buddy", 10); */

    Robot buddy;

    // create a new instance of buddy only once

    @BeforeAll
    public void setup() {
        buddy = new Robot("buddy", 10);
        System.out.println("in setup");
    }

    // reset Boolean flag working to false before each test.

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException {
        Class secretClass = buddy.getClass();
        System.out.println("in init");

        /*Retrieve the field age */
        Field f = secretClass.getDeclaredField("working");

        /* make sure the field is accessible. */
        f.setAccessible(true);
        f.setBoolean(buddy, false);
    }

    @Test
    public void getName() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void isNotWorking() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void isWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void getWorkingMsgFail1() {
        assertEquals("I am in working mode", buddy.getWorkingMsg());
    }

    @Test()
    @DisplayName("getWorkingMsgFail catch the expection")

    public void
    getWorkingMsgFail() {
        assertThrows(IllegalStateException.class, () ->
        {
            buddy.getWorkingMsg();
        });
    }

    @Test()
    public void testName_Fail() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            Robot chuck = new Robot("", 10);
        });
    }

    @Test
    void timeoutExceeded() { // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms assertTimeout(ofMillis(10), () -> { // Simulate task that takes more than 10 ms. buddy.waitTillWorking(); }); }
    }
}