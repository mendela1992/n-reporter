package nReporter.helpers;

import nReporter.core.Base;
import nReporter.models.NReport;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static nReporter.NLogger.nLogger;

public class Dashboard extends Base {

    private LinkedHashMap<String, Object> summary;
    private HashMap<String, Integer> testDonuts;

    public Dashboard(NReport report) {
        this.summary = new LinkedHashMap<>();
        this.summary.put("Tests", report.getTests().entrySet().size());
        this.summary.put("Start Time", this.dateToFormat("yyyy-MM-dd HH:mm:ss.S", report.getStartTime()));
        this.summary.put("End Time", this.dateToFormat("yyyy-MM-dd HH:mm:ss.S", report.getEndTime()));
        this.summary.put("Duration", this.formattedExecutionTime(report.getStartTime(), report.getEndTime()));
        this.testDonuts = new HashMap<>();
        Arrays.stream(Status.values()).forEach((Status status) -> testDonuts.put(status.name(),
                (int) report.getTests().values().stream()
                        .filter(test -> test.getTestStatus() != null
                                && test.getTestStatus().isDisplayed()
                                && test.getTestStatus().equals(status)).count()));
        nLogger.debug ("Prepared dashboard report...");
    }


    /**
     * Get Dashboard Summary
     * @return Dashboard summary
     */
    public LinkedHashMap<String, Object> getSummary() {
        return summary;
    }

    public HashMap<String, Integer> getTestDonuts() {
        return testDonuts;
    }
}
