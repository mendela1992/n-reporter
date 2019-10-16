package nReporter.models;


import nReporter.helpers.Status;
import org.joda.time.DateTime;

import static nReporter.NLogger.nLogger;

/**
 * Result model class to hold the test results.
 *
 * @author Nelson. Kelechi
 */
public class NStep {

    private String message;
    private Status status;
    private DateTime timestamp;
    private String screenshot;
    private Throwable exception;

    /**
     * Result with Status, message, screenshot and exception.
     *
     * @param status         Result Status
     * @param message        Result Message
     * @param timestamp      Result Timestamp
     * @param screenshotPath Result screenshot path
     * @param exception Exception to be displayed.
     */
    public NStep(DateTime timestamp, Status status, String message, String screenshotPath, Throwable exception) {
        nLogger.debug ("Adding new step...");
        if (status == null) {
            nLogger.error ("Step Status can not be null or empty.");
            throw new IllegalStateException ("Step Status can not be null or empty.");
        }

        if (message == null || "".equals (message)) {
            nLogger.error ("Step Message can not be null or empty.");
            throw new IllegalStateException ("Step Message can not be null or empty.");
        }

        if (timestamp == null) {
            nLogger.error ("Step Timestamp can not be null or empty.");
            throw new IllegalStateException ("Step Timestamp can not be null or empty.");
        }

        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.screenshot = screenshotPath;
        this.exception = exception;
        nLogger.info ("New result added. Timestamp: " + timestamp + " - Status: " + status + " - message: " + message + " - screenshot: " + screenshotPath + " - Exception: " + exception);
    }

    /**
     * Get result Status.
     *
     * @return Timestamp string
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Get Result message.
     *
     * @return Message String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Return result timestamp.
     *
     * @return Timestamp string
     */
    public DateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Get result screenshot.
     *
     * @return Screenshot path
     */
    public String getScreenshot() {
        return screenshot;
    }

    /**
     * Set result screenshot
     *
     * @param screenshot Screenshot path
     */
    public void setScreenshot(String screenshot) {
        nLogger.debug ("Adding Screenshot...");
        this.screenshot = screenshot;
        nLogger.info ("New Screenshot added: " + screenshot);
    }

    public Throwable getException() {
        return exception;
    }
}
