package nReporter.helpers;

/**
 * Status with default colours
 */
public enum Status {

    /**
     * Info Status
     */
    INFO("turquoise", false),
    /**
     * Pass Status
     */
    PASS("green", true),
    /**
     * Warning Status
     */
    WARN("orange", true),
    /**
     * Skip Status
     */
    SKIP("#f0c500", true),
    /**
     * Fail Status
     */
    FAIL("red", true),
    /**
     * Fatal Status
     */
    FATAL("orangered", true);


    private String colour;
    private  boolean isDisplayed;

    /**
     * Private Status constructor
     *
     * @param colour Status' colour
     */
    Status(String colour, boolean isDisplayed) {
        this.colour = colour;
        this.isDisplayed = isDisplayed;
    }

    public boolean isDisplayed() {
        return isDisplayed;
    }

    /**
     * Get Status color
     *
     * @return String representation of state color
     */
    public String getColour() {
        return colour;
    }

    /**
     * Set Status color
     *
     * @param colour Value of status color, (RGB, HEX, RGBA)
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
}
