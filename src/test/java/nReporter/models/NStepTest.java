package nReporter.models;

import nReporter.helpers.Status;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NStepTest {

    private NStep step;
    private String message = "Test Message", screenshot = null;
    private Status status = Status.SKIP;
    private DateTime dateTime = DateTime.now ( );
    private Throwable exception = new Exception ("Test Exception");

    @BeforeEach
    void setUp() {
        this.step = new NStep (dateTime, status, message, screenshot, exception);
    }

    @Test
    void getConstructor() {
        try {
            this.step = new NStep (dateTime,null,  message, screenshot, exception);
        } catch (IllegalStateException e){
            assertEquals ("Step Status can not be null or empty.", e.getMessage ());
        }
    }

    @Test
    void getConstructor2() {
        try {
            this.step = new NStep (dateTime,status,  null, screenshot, exception);
        } catch (IllegalStateException e){
            assertEquals ("Step Message can not be null or empty.", e.getMessage ());
        }
    }


    @Test
    void getConstructor3() {
        try {
            this.step = new NStep (null,status,  message, screenshot, exception);
        } catch (IllegalStateException e){
            assertEquals ("Step Timestamp can not be null or empty.", e.getMessage ());
        }
    }


    @Test
    void getStatus() {
        assertEquals (status, step.getStatus ( ));
    }

    @Test
    void getMessage() {
        assertEquals (message, step.getMessage ( ));
    }

    @Test
    void getTimestamp() {
        assertEquals (dateTime, step.getTimestamp ( ));
    }

    @Test
    void getScreenshot() {
        assertEquals (screenshot, step.getScreenshot ( ));
    }

    @Test
    void setScreenshot() {
        step.setScreenshot ("New Picture");
        assertEquals ("New Picture", step.getScreenshot ( ));
    }

    @Test
    void getException() {
        assertEquals (exception, step.getException ( ));
    }
}