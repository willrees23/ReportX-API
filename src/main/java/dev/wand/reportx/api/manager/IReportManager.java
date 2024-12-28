package dev.wand.reportx.api.manager;

import dev.wand.reportx.api.model.Report;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Manages reports and provides methods to interact with them. <br>
 * This interface is implemented by the platform-specific module.
 * <br> <br>
 * Methods provided include retrieving, creating, and updating reports.
 */
public interface IReportManager {

    /**
     * Returns a list of all reports. <br>
     * This method is asynchronous and returns a {@link CompletableFuture}.
     *
     * @return a list of all reports
     * @see CompletableFuture
     * @see Report
     */
    CompletableFuture<List<Report>> getReports();

    /**
     * Creates a new report. <br>
     * This method is asynchronous and returns a {@link CompletableFuture}.
     *
     * @param report the report to create
     * @return a boolean indicating whether the report was created successfully
     * @see CompletableFuture
     * @see Report
     */
    CompletableFuture<Boolean> create(Report report);
}
