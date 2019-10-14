package nReporter.models;

import nReporter.helpers.Status;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NTestTest {

    private NTest test;
    private String testName= "Test Name", testDescription = "description";
    private DateTime startTime = DateTime.now ();
    private String message = "Message expected", screenshot = "My Screenshot";
    private Status status = Status.SKIP;
    private DateTime dateTime = DateTime.now ( );
    private Throwable exception = new Exception ("Test Exception");

    private
    @BeforeEach
    void setUp() {
        test = new NTest (testName, testDescription, startTime);
    }

    @Test
    void logStepResult() {


    }

    @Test
    void constructor() {
        try {
            test = new NTest (null, testDescription, startTime);
        } catch (IllegalStateException e){
            assertEquals ("Test name is empty or equal to null.", e.getMessage ());
        }
    }

    @Test
    void pass() {
        test.pass (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testPass() {
        test.pass (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void fail() {
        test.fail (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testFail() {
        test.fail (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void testFail1() {
        test.fail (message, screenshot, exception);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
        assertEquals (exception, test.getStepResults ().get (0).getException ());
    }

    @Test
    void skip() {
        test.skip (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testSkip() {
        test.skip (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void fatal() {
        test.fatal (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testFatal() {
        test.fatal (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void testFatal1() {
        test.fatal (message, screenshot, exception);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
        assertEquals (exception, test.getStepResults ().get (0).getException ());
    }

    @Test
    void warning() {
        test.warning (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testWarning() {
        test.warning (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void info() {
        test.info (message);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
    }

    @Test
    void testInfo() {
        test.info (message, screenshot);
        assertEquals (message, test.getStepResults ().get (0).getMessage ());
        assertEquals (screenshot, test.getStepResults ().get (0).getScreenshot ());
    }

    @Test
    void getEndTime() {
        DateTime endTime = DateTime.now ();
        test.setEndTime (endTime);
        assertEquals (endTime, test.getEndTime ());
    }


    @Test
    void getStarTime() {
        DateTime startTime = DateTime.now ();
        test.setStarTime (startTime);
        assertEquals (startTime, test.getStarTime ());
    }


    @Test
    void getTestStatus() {
        test.setTestStatus (Status.INFO);
        assertEquals (Status.INFO, test.getTestStatus ());
    }

    @Test
    void getCategory() {
        test.setCategory ("Category test");
        assertEquals ("Category test", test.getCategory ());
    }

    @Test
    void getTestName() {
        assertEquals (testName, test.getTestName ());
    }

    @Test
    void getTestDescription() {
        assertEquals (testDescription, test.getTestDescription ());
    }

    @Test
    void getStepResults() {
        test.logStepResult (status, message, screenshot, exception);
        assertNotEquals (0, test.getStepResults ().size ());
    }

    @Test
    void getTags() {
        test.assignTags ("taggs", "Dick");
        assertNotEquals (0, test.getTags ().size ());
        assertEquals ("Dick", test.getTags ().get (1));
        assertEquals ("taggs", test.getTags ().get (0));
    }

    @Test
    void getTestExecutionTime() {
        test.setEndTime (test.getStarTime ().plusMinutes (30).plusSeconds (2).plusMillis (300));
        assertEquals ("0d 0h 30m 2s+300ms", test.getTestExecutionTime ());
    }

    @Test
    void getTestStats() {
        assertEquals (0, test.getTestStats ().size ());
    }
}