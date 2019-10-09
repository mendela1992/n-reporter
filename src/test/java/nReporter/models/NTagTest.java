package nReporter.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NTagTest {

    private NTag tag;
    private String expectedName = "tag Name", expectedDescription = "Tad description";
    @BeforeEach
    void setUp() {
        tag = new NTag (expectedName, expectedDescription);

    }

    @Test
    void getName() {
        assertEquals (expectedName, tag.getName ());
    }

    @Test
    void getDescription() {
        assertEquals (expectedDescription, tag.getDescription ());
    }
}