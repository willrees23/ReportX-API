package dev.wand.reportx.api.enums;

/**
 * Represents the status of a {@link dev.wand.reportx.api.model.Report}.
 */
public enum ReportStatus {

    PENDING,
    ACCEPTED,
    DENIED;

    /**
     * Under the hood, this method calls {@link ReportStatus#valueOf(String)}. <br>
     * It converts the specified name to uppercase before calling for you.
     *
     * @param name the name of the enum constant to match
     * @return the enum constant with the specified name
     */
    public static ReportStatus match(String name) {
        return valueOf(name.toUpperCase());
    }
}