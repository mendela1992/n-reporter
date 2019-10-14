package nReporter.models;

import nReporter.helpers.Status;
import nReporter.core.Base;
import org.joda.time.DateTime;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static nReporter.NLogger.*;
import static nReporter.helpers.Status.*;

public class NTest extends Base {

    private String testName, testDescription;
    private DateTime starTime, endTime;
    private List<NStep> stepResults;
    private Status testStatus;
    private LinkedHashMap<String, Integer> testStats;
    private List<String> tags;
    private String testExecutionTime, category;

    NTest(String testName, String testDescription, DateTime starTime) {
        nLogger.debug ("Adding new test...");
        try {
            if (!testName.isEmpty ( )) { // Check if test name if empty
                this.testName = testName;
                this.testDescription = testDescription;
                this.starTime = starTime;
                this.stepResults = new LinkedList<> ( );
                this.testStats = new LinkedHashMap<> ( );
                this.tags = new LinkedList<> ( );
            }
            nLogger.info ("New Test added. Name: " + testName + " - description: " + testDescription + " - Test Start Time: " + starTime);
        } catch (NullPointerException e) {
            nLogger.error ("Test name is empty or equal to null.");
            throw new IllegalStateException ("Test name is empty or equal to null.");
        }

    }

    /**
     * Log Step result manually
     *
     * @param timestamp  Step Result timestamp
     * @param status     Step Result Status
     * @param message    Step Result message
     * @param screenshot Step Result Screenshot
     */
    private void logStepResult(DateTime timestamp, Status status, String message, String screenshot, Throwable t) {
        nLogger.debug ("Logging test results...");
        /*Adding a new Step to the report*/
        this.getStepResults ( ).add (new NStep (timestamp, status, message, screenshot, t));
        nLogger.info ("Added Result to test: " + this.getTestName ( ) + ". Timestamp: " + timestamp + " - status: " + status + " - message: " + message + " - screenshot: " + screenshot + " - Exception: " + t);

        /*Update test status*/
        nLogger.debug ("Updating test '" + testName + "' status...");
        // Get List of step status ordinal desc ordinal
        List<Status> statuses = this.getStepResults ( ).stream ( ).filter ((NStep result) -> !result.getStatus ( ).equals (Status.INFO)).map (NStep::getStatus).sorted ((o1, o2) -> o2.ordinal ( ) - o1.ordinal ( )).collect (Collectors.toList ( ));

        // Assign the current status if it is the first step else get the first status from the list above
        if (statuses.isEmpty ( ))
            this.setTestStatus (status);
        else
            this.setTestStatus (statuses.get (0));
        nLogger.info ("Updated test '" + testName + "' status to '" + testStatus + "'");

        // Set Test end time
        this.setEndTime (timestamp);
    }

    /**
     * Log Step result with current time as timestamp
     *
     * @param status     Step Result Status
     * @param message    Step Result message
     * @param screenshot Step Result Screenshot
     */
    void logStepResult(Status status, String message, String screenshot, Throwable t) {
        this.logStepResult (DateTime.now ( ), status, message, screenshot, t);
    }

    //Logging Test Results methods


    /**
     * Log pass status message with current time as timestamp and no screenshot.
     *
     * @param message Step Result message
     * @return Current instance of Test
     */
    public NTest pass(String message) {
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
    public NTest pass(String message, String screenshotPath) {
        this.logStepResult (PASS, message, screenshotPath, null);
        return this;
    }

    /**
     * Log fail status message with current time as timestamp and no screenshot.
     *
     * @param message fail message
     * @return current instance of Test
     */
    public NTest fail(String message) {
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
    public NTest fail(String message, String screenshotPath) {
        this.fail (message, screenshotPath, null);
        return this;
    }

    /**
     * Log fail status message with current time as timestamp and a screenshot.
     *
     * @param message        fail message
     * @param screenshotPath fail screenshot path
     * @return Current instance of Test
     */
    public NTest fail(String message, String screenshotPath, Throwable t) {
        this.logStepResult (FAIL, message, screenshotPath, t);
        return this;
    }

    /**
     * Log skip status message with current time as timestamp and no screenshot.
     *
     * @param message skip message
     * @return current instance of Test
     */
    public NTest skip(String message) {
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
    public NTest skip(String message, String screenshotPath) {
        this.logStepResult (SKIP, message, screenshotPath, null);
        return this;
    }

    /**
     * Log fatal message
     *
     * @param message fatal message
     * @return current instance of Test
     */
    public NTest fatal(String message) {
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
    public NTest fatal(String message, String screenshotPath) {
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
    public NTest fatal(String message, String screenshotPath, Throwable t) {
        this.logStepResult (FATAL, message, screenshotPath, t);
        return this;
    }

    /**
     * Log warning message
     *
     * @param message warning message
     * @return current instance of Test
     */
    public NTest warning(String message) {
        return this.warning (message, null);
    }

    /**
     * Log warning message with screenshot
     *
     * @param message        warning message
     * @param screenshotPath warning screenshot path
     * @return current instance of Test
     */
    public NTest warning(String message, String screenshotPath) {
        this.logStepResult (WARN, message, screenshotPath, null);
        return this;
    }

    /**
     * Log info message
     *
     * @param message info message
     * @return current instance of Test
     */
    public NTest info(String message) {
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
    public NTest info(String message, String screenshotPath) {
        this.logStepResult (INFO, message, screenshotPath, null);
        return this;
    }
    /*Getters and Setters*/

    /**
     * Get Test end time.
     *
     * @return test end time.
     */
    public DateTime getEndTime() {
        return endTime;
    }

    /**
     * Set test end time.
     *
     * @param endTime Test end time.
     */
    public void setEndTime(DateTime endTime) {
        nLogger.debug ("Test end time...");
        this.endTime = endTime;
        this.testExecutionTime = this.formattedExecutionTime (this.starTime, this.endTime);
        nLogger.info ("End time: " + endTime + ", test execution time: " + testExecutionTime);
    }

    /**
     * Get test start time.
     *
     * @return Test start time.
     */
    public DateTime getStarTime() {
        return starTime;
    }

    /**
     * Set test start time.
     *
     * @param starTime Test start time.
     */
    public void setStarTime(DateTime starTime) {
        this.starTime = starTime;
    }

    /**
     * Get test status .
     *
     * @return test status.
     */
    public Status getTestStatus() {
        return testStatus;
    }

    /**
     * Set test status.
     *
     * @param testStatus Test status.
     */
    public void setTestStatus(Status testStatus) {
        this.testStatus = testStatus;
    }

    /**
     * Get Test category
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set test category
     *
     * @param category category
     * @return Test current instance
     */
    public NTest setCategory(String category) {
        nLogger.debug ("Set test category...");
        this.category = category;
        nLogger.info ("Set Test '" + testName + "' category to" + category);
        return this;
    }

    /**
     * Get test name.
     *
     * @return Test name.
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Get test description.
     *
     * @return Test description.
     */
    public String getTestDescription() {
        return testDescription;
    }

    /**
     * Get list of test steps results.
     *
     * @return Collection of test steps.
     */
    public List<NStep> getStepResults() {
        return stepResults;
    }

    /**
     * Get List of test tags.
     *
     * @return Collection of tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Get Test execution time.
     *
     * @return Execution time
     */
    public String getTestExecutionTime() {
        return testExecutionTime;
    }

    /**
     * Get Tests statistic
     *
     * @return test statistic.
     */
    public LinkedHashMap<String, Integer> getTestStats() {
        return testStats;
    }

    /**
     * Set tag(s)
     *
     * @param tags Tag(s)
     * @return Current Test instance
     */
    public NTest assignTags(String... tags) {
        nLogger.debug ("Assigning tag(s)...");
        this.tags.addAll (asList (tags));
        nLogger.info ("Assigned tag(s): " +tags);
        return this;
    }
}