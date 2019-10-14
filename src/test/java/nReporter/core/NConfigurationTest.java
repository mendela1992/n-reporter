package nReporter.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NConfigurationTest {

    private String templatePath = "C:\\n-reporter\\src\\main\\resources\\templates\\report.ftlh";

    @Test
    void setReportTemplate() throws IOException {
        NConfiguration.getInstance (templatePath);
        assertNotNull (NConfiguration.getInstance (templatePath), "Expected instance of NcConfiguration when loading custom template.");
    }

    @Test
    void setReportTemplate1() throws IOException {
        NConfiguration.getInstance ( );
        assertNotNull (NConfiguration.getInstance (), "Expected an instance of NConfiguration when loading default template.");
    }

    @Test
    void getReportTemplate() throws NullPointerException, IOException {
        assertNotNull (NConfiguration.getInstance (templatePath).getReportTemplate ( ), "Report Template should be null.");
    }

    @Test
    void getInstance() throws IOException {
        assertNotNull (NConfiguration.getInstance (templatePath), "Insatnce should not be not.");
    }

    @AfterEach
    public void tearDown(){
        NConfiguration.close ();
    }
}