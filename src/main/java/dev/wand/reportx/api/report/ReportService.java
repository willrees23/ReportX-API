package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import dev.wand.reportx.api.report.callback.CreateReportCallback;
import dev.wand.reportx.api.report.callback.FetchReportCallback;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    void createReport(Report report, CreateReportCallback callback);

    void fetchReport(String reportId, FetchReportCallback callback);

    List<Report> getReportsByStatus(ReportStatus status);

    void resolveReport(String reportId, String staffUuid, String reason, ReportStatus status);
}