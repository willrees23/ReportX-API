package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
public class Report {


    private String id;
    private String creator, target, reason, server;
    @Setter
    private Instant dateTime;

    @Setter
    private Instant resolvedDateTime;
    @Setter
    private String resolvedBy, resolvedReason;
    @Setter
    private ReportStatus status;
}
