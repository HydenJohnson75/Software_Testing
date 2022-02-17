import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class RobotTest {

    Robot buddy = new Robot("buddy",10);

    @Test
    public void test_Constructor()
    {
        assertEquals( "buddy", buddy.getName());
        assertEquals(10,buddy.getAge());
    }

    @Test
    public void isWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void isNotWorking()
    {
        assertFalse(buddy.isWorking());
    }

    @Test()
    public void testName_Fail()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            Robot chuck = new Robot("Chuck",10);
        });
    }

    @Test
    public void getWorkingMsg()
    {
        buddy.talkToRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }


    @Test()
    public void getWorkingMsgFail()
    {
        assertThrows(IllegalStateException.class, () ->
        {
            buddy.getWorkingMsg();
        });
    }

}