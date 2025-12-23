package dev.wand.reportx.api.report.repository;

import dev.wand.reportx.api.enums.ReportStatus;
import dev.wand.reportx.api.report.Report;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReportRepository {

    Report save(Report report);

    Optional<Report> findById(String reportId);

    List<Report> findByStatus(ReportStatus status);

    void updateStatus(String reportId, UUID staffUuid, String reason, ReportStatus status);
}