package dev.wand.reportx.api.report.callback;

import dev.wand.reportx.api.report.Report;

public interface CreateReportCallback {

    void onReportCreated(Report report);
}
