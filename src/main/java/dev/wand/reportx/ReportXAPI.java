package dev.wand.reportx;

import dev.wand.reportx.report.ReportService;
import lombok.Getter;
import lombok.Setter;

public final class ReportXAPI {

    @Getter
    @Setter
    private static ReportService reportService;
}
