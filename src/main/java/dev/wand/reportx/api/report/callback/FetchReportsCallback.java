package dev.wand.reportx.api.report.callback;

import dev.wand.reportx.api.report.Report;

import java.util.List;

public interface FetchReportsCallback {

    void onReportsFetched(List<Report> reports);
}

