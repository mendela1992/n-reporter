package nReporter.core;

import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {

    private Base base;
    private Object expected = "1992-08-15 07:35:00";

    @BeforeEach
    void setUp() {
        base = new Base ( );
    }


    @Test
    void dateToFormat() {
        expected = "1992-08-15 07:35:00";
        assertEquals (expected, base.dateToFormat ("yyyy-MM-dd HH:mm:ss", new DateTime (1992, 8, 15, 07, 35, 00, 00)));
    }

    @Test
    void formattedExecutionTime() {
        expected = "0d 0h 0m 54s+978ms";
        DateTime startTime = DateTime.now ( );
        DateTime endTime = startTime.plusSeconds (54).plusMillis (978);
        assertEquals (expected, this.base.formattedExecutionTime (startTime, endTime));
    }

    @Test
    void getColourConfigurations() {
        assertNotNull (this.base.getColourConfigurations ());
     assertTrue (this.base.getColourConfigurations ().size () == 6);
    }

    @AfterEach
    void tearDown() {
        base = null;
    }
}