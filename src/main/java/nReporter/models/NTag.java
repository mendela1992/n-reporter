package nReporter.models;

import org.joda.time.IllegalFieldValueException;

import static nReporter.NLogger.nLogger;

/**
 * @author Nelson Dick Kelechi
 * @version 1.0
 */
public class NTag {

    private String name;
    private String description;

    /**
     * Tag
     *
     * @param name        Tag Name
     * @param description Tag description
     */
    public NTag(String name, String description) {
        nLogger.debug ("Adding tag...");
        if (name.isEmpty ()) {
            nLogger.error ("Tag name cannot be null.");
            throw new IllegalArgumentException ("Tag name cannot be null.");
        }
        this.name = name;
        this.description = description;
        nLogger.info ("New tag added. Name: " + name + " - description: " + description);
    }

    /**
     * Get tag name
     *
     * @return tag name
     */
    public String getName() {
        return name;
    }

    /**
     * Get tag description (optional)
     *
     * @return tag description
     */
    public String getDescription() {
        return description;
    }
}
