package nReporter;

import freemarker.template.TemplateException;
import nReporter.models.NReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NReportTest {
    private String templatePath = "C:\\n-reporter\\src\\main\\resources\\templates\\report.ftlh";
    @BeforeEach
    void setUp() {
    }

    @Test
    void flush() throws IOException, TemplateException, InterruptedException {
        NReport report = new NReport ("./Reports", templatePath);
        report.setReportName ("STAN project").setSystemInfo ("Version", "1.4.0.30");
        report.createTest ("Test name", "Test Description")
                .setCategory ("Regression")
                .assignTags ("tag 1", "Tag2");
        report.pass ("Pass message");
        report.pass ("Pass with screenshot", "https://dummyimage.com/600x400/000/fff&text=Passed__2.png");
//Thread.sleep (3000);
        report.createTest ("Test 2", "Test 2 description");
        report.fail ("Message");
        report.fail ("Fail message with Throwable option", "https://dummyimage.com/600x400/000/fff&text=Passed__2.png", new Exception ("Testing expection message."));
        report.skip ("Skipping");

        for (int i = 0; i < 10; i++) {
            report.createTest ("Test Name "+i, "Test Description " + i).assignTags ("Tag for test" + i, null)
                    .setCategory ("Category " + i).info ("Info message for test "+ i).warning ("Warning message from Test" + i).pass ("pass message for test "+ i)
                    .fatal ("Fatal Message", null, new Exception ("Fatal Error on test "+ i));
//            Thread.sleep (4000);
        }


        // Flush report
        report.flush (false);
    }
}