package dev.wand.reportx.api;

import dev.wand.reportx.api.report.repository.ReportRepository;
import dev.wand.reportx.api.report.ReportService;
import lombok.Getter;
import lombok.Setter;

public final class ReportXAPI {

    @Getter
    @Setter
    private static ReportService reportService;

    @Getter
    @Setter
    private static ReportRepository reportRepository;
}
