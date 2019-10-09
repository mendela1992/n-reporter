package nReporter.core;

import nReporter.helpers.Status;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;

import static nReporter.NLogger.nLogger;

public class Base {

    private LinkedHashMap<String, String> colourConfigurations;

    protected Base() {
        this.colourConfigurations = new LinkedHashMap<> ( );
        Arrays.stream (Status.values ( )).forEach (status -> colourConfigurations.put (status.name ( ), status.getColour ( )));
    }

    /**
     * Convert desired date to specific toDateTimeFormat
     *
     * @param format Desired toDateTimeFormat
     * @param date   Date time to convert
     * @return String of formatted date
     */
    protected String dateToFormat(String format, DateTime date) {
        return new SimpleDateFormat (format).format (date.toDate ( ));
    }

    /**
     * Format duration time (eg: 1d 2h 4m 5s+200ms)
     *
     * @param startTime Start time value
     * @param endTime   end time value
     * @return formatted duration time
     */
    protected String formattedExecutionTime(DateTime startTime, DateTime endTime) {
        Duration testDuration = new Duration (startTime, endTime);
        Period period = testDuration.toPeriod ( );
        PeriodFormatter minutesAndSeconds = new PeriodFormatterBuilder ( )
                .printZeroAlways ( ).appendDays ( ).appendSuffix ("d ").appendHours ( ).appendSuffix ("h ")
                .appendMinutes ( ).appendSuffix ("m ")
                .appendSeconds ( ).appendSuffix ("s+").appendMillis ( ).appendSuffix ("ms")
                .toFormatter ( );
        return minutesAndSeconds.print (period);
    }


    /**
     * Get default status colours
     * @return list of status and respective colours.
     */
    public LinkedHashMap<String, String> getColourConfigurations() {
        return colourConfigurations;
    }
}
