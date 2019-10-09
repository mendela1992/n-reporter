package nReporter.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NConfigurationTest {

    private String templatePath = "C:\\Projects\\n-reporter\\src\\main\\resources\\templates\\report.flth";
    @Test
    void setReportTemplate() throws IOException {
        try {
            NConfiguration.getInstance ( templatePath).setReportTemplate ("nelson");
        } catch (NullPointerException e) {
            assertNull (e.getMessage ( ), "Expected Null Pointer Exception");
        }

    }

    @Test
    void setReportTemplate1() throws NullPointerException {
        try {
            NConfiguration.getInstance ( templatePath).setReportTemplate ("/templates");
        } catch (IOException e) {
            assertNull (e.getCause ( ), "Expected Null Pointer Exception");
        }

    }

    @Test
    void getReportTemplate() throws NullPointerException, IOException {
        assertNotNull (NConfiguration.getInstance ( templatePath).getReportTemplate ( ), "Report Template should be null.");
    }

    @Test
    void getInstance() throws IOException {
        assertNotNull (NConfiguration.getInstance ( templatePath), "Insatnce should not be not.");
    }
}