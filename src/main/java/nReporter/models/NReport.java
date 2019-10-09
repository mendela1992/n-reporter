package nReporter.models;


import freemarker.template.TemplateException;
import nReporter.helpers.Status;
import nReporter.core.Base;
import nReporter.core.NConfiguration;
import nReporter.helpers.Dashboard;
import org.joda.time.DateTime;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

import static java.util.Arrays.asList;
import static nReporter.NLogger.nLogger;
import static nReporter.helpers.Status.*;

public class NReport extends Base {

    private String reportDestinationFolder;
    private DateTime startTime, endTime;
    private NTest currentTest;
    private String reportName, projectName, user;
    private LinkedHashMap<String, NTest> tests;
    private LinkedHashMap<String, String> environments;
    private NConfiguration configuration;
    private HashMap<Object, Object> root;


    public NReport(String reportDestinationFolder, String templatePath) throws IOException {
        nLogger.debug ("initialising Report...");
        this.configuration = NConfiguration.getInstance (templatePath);
        this.reportDestinationFolder = reportDestinationFolder;
        boolean mkdirs = new File (reportDestinationFolder).mkdirs ( );
        System.setProperty ("reportDestinationFolder", reportDestinationFolder);
        this.root = new HashMap<> ( );
        this.tests = new LinkedHashMap<> ( );
        this.environments = new LinkedHashMap<> ( );
        nLogger.info ("Report initialised.");
    }

    public NReport(String templatePath) throws IOException {
        nLogger.debug ("initialising Report...");
        this.configuration = NConfiguration.getInstance (templatePath);
        this.reportDestinationFolder = "";
        System.setProperty ("reportDestinationFolder", reportDestinationFolder);
        boolean mkdirs = new File (reportDestinationFolder).mkdirs ( );
        this.root = new HashMap<> ( );
        this.tests = new LinkedHashMap<> ( );
        this.environments = new LinkedHashMap<> ( );
        nLogger.info ("Report initialised.");
    }

    /**
     * Create Test by passing a Name for you test and an optional description for your test.
     *
     * @param testName        Test Name
     * @param testDescription Test Description
     * @return Current instance of the report.
     */
    public NTest createTest(String testName, String testDescription) {
        nLogger.debug ("Creating test...");
        if (projectName.isEmpty ( )) {
            nLogger.error ("Project name missing.");
            throw new NullPointerException ("Project name missing");
        }
        DateTime now = DateTime.now ( );
        this.setStartTime (now);
        this.currentTest = new NTest (testName, testDescription, now);
        this.tests.put ("test" + this.tests.size ( ), currentTest);
        nLogger.info ("New Test created. Name: " + testName + " - description: " + testDescription + " - Timestamp: " + now);
        return currentTest;
    }

    /**
     * Flush method writes your results the report file
     */
    public void flush() throws IOException, TemplateException {
        this.flush (false);
    }

    /**
     * Flush method writes your results the report file
     */
    public void flush(boolean displayReport) throws IOException, TemplateException {
        // Set report end time.
        this.setEndTime (currentTest.getEndTime ( ));
        // Tests Stats
        this.currentTest.getTestStats ( ).put ("Total", this.currentTest.getStepResults ( ).size ( ));
        asList (Status.values ( )).forEach ((Status testStatus) -> {
            int count = (int) this.currentTest.getStepResults ( ).stream ( ).filter (step -> testStatus.isDisplayed ( ) && step.getStatus ( ).equals (testStatus)).count ( );
            this.currentTest.getTestStats ( ).put (testStatus.name ( ), count);
        });

        // Output variables for reporting
        this // Project
                .setRoot ("Project", this.projectName) //
                .setRoot ("tests", this.tests)
                .setRoot ("dashboard", new Dashboard (this))
                .setRoot ("environments", this.environments)
                .setRoot ("listColours", this.getColourConfigurations ( ));

        nLogger.debug ("Creating html Report...");
        // Preparing report outputting
        File report = new File (Objects.requireNonNull (this.getReportPath ( )));
        FileWriter fileWriter = new FileWriter (report);
        this.configuration.getReportTemplate ( ).process (this.root, fileWriter);
        fileWriter.flush ( );
        fileWriter.close ( );
        nLogger.info ("Created report: " + report.getAbsolutePath ( ));
        if (displayReport) {
            Desktop desktop = Desktop.getDesktop ( );
            if (report.exists ( )) {
                try {
                    desktop.open (report);
                    nLogger.info ("Opened report on default browser.");
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        }
    }

    /*Getters and Setters*/

    /**
     * Get System Information.
     *
     * @param key System key value to be retrieved.
     * @return System information value.
     */
    public String getSystemInfo(String key) {
        return environments.get (key);
    }

    /**
     * Add System Information.
     *
     * @param key   key.
     * @param value value.
     * @return Report current instance
     */
    public NReport setSystemInfo(String key, String value) {
        this.environments.put (key, value);
        nLogger.info ("New System info added. Key: " + key + " - value: " + value);
        return this;
    }

    /**
     * Get report start time.
     *
     * @return start tine.
     */
    public DateTime getStartTime() {
        return startTime;
    }

    /**
     * Set Report start time.
     *
     * @param startTime start time.
     */
    public NReport setStartTime(DateTime startTime) {
        if (this.startTime == null) {
            this.startTime = startTime;
            this.root.put ("startTime", this.startTime);
            nLogger.info ("Report start time: " + startTime);
        }
        return this;
    }

    /**
     * GEt report end time.
     *
     * @return end time.
     */
    public DateTime getEndTime() {
        return endTime;
    }

    /**
     * Set Report end time.
     *
     * @param endTime end time.
     */
    public NReport setEndTime(DateTime endTime) {
        this.endTime = endTime;
        nLogger.info ("Report end time: " + endTime);
        return this;
    }

    /**
     * Get Project Name.
     *
     * @return Project Name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set Project Name.
     *
     * @param projectName Project Name.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
        this.setSystemInfo ("Project", this.projectName);
    }

    /**
     * Get user execution name.
     *
     * @return user name.
     */
    public String getUser() {
        return user;
    }

    /**
     * Set user execution name.
     *
     * @param user user execution name.
     * @return Current instance of report.
     */
    public NReport setUser(String user) {
        this.user = user;
        this.setSystemInfo ("User", this.user);
        this.setRoot ("user", user);
        return this;
    }

    /**
     * Get report name.
     *
     * @return report name.
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Get current Test information.
     *
     * @return Test information.
     */
    public NTest getCurrentTest() {
        return currentTest;
    }

    /**
     * Get Report Destination folder.
     *
     * @return Report Destination
     */
    public String getReportDestinationFolder() {
        if (!reportDestinationFolder.endsWith ("\\"))
            return reportDestinationFolder + "\\";
        nLogger.info ("Report Folder path: " + reportDestinationFolder);
        return reportDestinationFolder;
    }

    public NReport setReportDestinationFolder(String reportDestinationFolder) {
        this.reportDestinationFolder = reportDestinationFolder;
        nLogger.debug ("Set report folder path.");
        return this;
    }

    /**
     * Resolve path to report.
     *
     * @return path to report.
     */
    private String getReportPath() {
        String report = !this.getReportName ( ).contains (".html") ? this.getReportName ( ).concat (".html") : this.getReportName ( );
        return this.getReportDestinationFolder ( ).concat (report);
    }

    /**
     * Get list of Tests.
     *
     * @return list of tests.
     */
    public LinkedHashMap<String, NTest> getTests() {
        return tests;
    }

    /**
     * Set Report root information
     *
     * @param key   key
     * @param value value
     * @return cCurrent instance of report.
     */
    private NReport setRoot(String key, Object value) {
        this.root.put (key, value);
        nLogger.debug ("New report root added. Key: " + key + " - value: " + value);
        return this;
    }

    /**
     * Set the name of your report.
     *
     * @param reportName report name | example: 'report.html' or 'report'
     * @return Current instance of report
     */
    public NReport setReportName(String reportName) {
        this.reportName = reportName;
        if (this.projectName == null) {
            this.setProjectName (reportName);
        }
        this.setUser (System.getProperty ("user.name"));
        return this;
    }

    /**
     * Set Status colour.
     *
     * @param status status name.
     * @param color  Status color.
     * @return BAse current instance.
     */
    public NReport setStatusColour(Status status, String color) {
        nLogger.info ("Set '" + status + "' colour to '" + color + "'");
        status.setColour (color);
        return this;
    }

    public NConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Log pass status message with current time as timestamp and no screenshot.
     *
     * @param message Step Result message
     * @return Current instance of Test
     */
    public NReport pass(String message) {
        this.pass (message, null);
        return this;
    }

    /**
     * Log pass status message with current time as timestamp and a screenshot.
     *
     * @param message        Step Result message
     * @param screenshotPath Step Result screenshot path
     * @return current instance of Test
     */
    public NReport pass(String message, String screenshotPath) {
        this.currentTest.logStepResult (PASS, message, screenshotPath, null);
        return this;
    }

    /**
     * Log fail status message with current time as timestamp and no screenshot.
     *
     * @param message fail message
     * @return current instance of Test
     */
    public NReport fail(String message) {
        this.fail (message, null);
        return this;
    }

    /**
     * Log fail status message with current time as timestamp and a screenshot.
     *
     * @param message        fail message
     * @param screenshotPath fail screenshot path
     * @return Current instance of Test
     */
    public NReport fail(String message, String screenshotPath) {
        this.currentTest.logStepResult (FAIL, message, screenshotPath, null);
        return this;
    }

    /**
     * Log fail status message with current time as timestamp and a screenshot.
     *
     * @param message        fail message
     * @param screenshotPath fail screenshot path
     * @return Current instance of Test
     */
    public NReport fail(String message, String screenshotPath, Throwable t) {
        this.currentTest.logStepResult (FAIL, message, screenshotPath, t);
        return this;
    }

    /**
     * Log skip status message with current time as timestamp and no screenshot.
     *
     * @param message skip message
     * @return current instance of Test
     */
    public NReport skip(String message) {
        this.skip (message, null);
        return this;
    }

    /**
     * Log skip message with screenshot
     *
     * @param message        skip message
     * @param screenshotPath skip screenshot path
     * @return current instance of Test
     */
    public NReport skip(String message, String screenshotPath) {
        this.currentTest.logStepResult (SKIP, message, screenshotPath, null);
        return this;
    }

    /**
     * Log fatal message
     *
     * @param message fatal message
     * @return current instance of Test
     */
    public NReport fatal(String message) {
        this.fatal (message, null, null);
        return this;
    }

    /**
     * Log fatal message with screenshot
     *
     * @param message        fatal message
     * @param screenshotPath fatal screenshot path
     * @return current instance of Test
     */
    public NReport fatal(String message, String screenshotPath) {
        this.fatal (message, screenshotPath, null);
        return this;
    }

    /**
     * Log fatal message with screenshot
     *
     * @param message        fatal message
     * @param screenshotPath fatal screenshot path
     * @return current instance of Test
     */
    public NReport fatal(String message, String screenshotPath, Throwable t) {
        this.currentTest.logStepResult (FATAL, message, screenshotPath, t);
        return this;
    }

    /**
     * Log warning message
     *
     * @param message warning message
     * @return current instance of Test
     */
    public NReport warning(String message) {
        return this.warning (message, null);
    }

    /**
     * Log warning message with screenshot
     *
     * @param message        warning message
     * @param screenshotPath warning screenshot path
     * @return current instance of Test
     */
    public NReport warning(String message, String screenshotPath) {
        this.currentTest.logStepResult (WARN, message, screenshotPath, null);
        return this;
    }

    /**
     * Log info message
     *
     * @param message info message
     * @return current instance of Test
     */
    public NReport info(String message) {
        this.info (message, null);
        return this;
    }

    /**
     * Log info message with screenshot
     *
     * @param message        info message
     * @param screenshotPath info screenshot path
     * @return current instance of Test
     */
    public NReport info(String message, String screenshotPath) {
        this.currentTest.logStepResult (INFO, message, screenshotPath, null);
        return this;
    }


}
