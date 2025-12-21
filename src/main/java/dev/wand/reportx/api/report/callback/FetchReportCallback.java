package dev.wand.reportx.api.report.callback;

import dev.wand.reportx.api.report.Report;

import java.util.Optional;

public interface FetchReportCallback {

    void onReportFetched(Report report);
}
