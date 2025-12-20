package dev.wand.reportx.report;

import dev.wand.reportx.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

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
