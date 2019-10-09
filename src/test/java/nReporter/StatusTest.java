package nReporter;

import nReporter.helpers.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void isDisplayed() {
        Status status = Status.FAIL;
        assertTrue (status.isDisplayed ());
    }

    @Test
    void setColour() {
        Status fatalColor = Status.FATAL;
        fatalColor.setColour ("green");
        assertEquals ("green", fatalColor.getColour ());
    }
}