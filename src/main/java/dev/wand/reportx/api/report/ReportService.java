package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Report createReport(Report report);

    Optional<Report> getReport(String reportId);

    List<Report> getReportsByStatus(ReportStatus status);

    void resolveReport(String reportId, String staffUuid, String reason, ReportStatus status);
}
