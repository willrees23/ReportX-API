package dev.wand.reportx.api.model;

import dev.wand.reportx.api.enums.ReportStatus;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public record Report(
        String id,
        ReportPlayer victim,
        ReportPlayer operator,
        String reason,
        Instant timestamp,
        ReportStatus status,
        @Nullable ReportResult result) {
}
