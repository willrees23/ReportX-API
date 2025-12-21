package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import dev.wand.reportx.api.report.callback.CreateReportCallback;
import dev.wand.reportx.api.report.callback.FetchReportCallback;
import dev.wand.reportx.api.report.callback.FetchReportsCallback;
import dev.wand.reportx.api.report.callback.ResolveReportCallback;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    void createReport(Report report, CreateReportCallback callback);

    void fetchReport(String reportId, FetchReportCallback callback);

    // Asynchronous fetch that uses a callback
    void fetchReportsByStatus(ReportStatus status, FetchReportsCallback callback);

    // Asynchronous resolve operation with callback indicating success
    void resolveReport(String reportId, String staffUuid, String reason, ReportStatus status, ResolveReportCallback callback);
}