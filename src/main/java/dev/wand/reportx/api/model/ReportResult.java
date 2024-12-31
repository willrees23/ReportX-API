package dev.wand.reportx.api.model;

import lombok.Getter;

import java.time.Instant;

public record ReportResult(ReportPlayer handler, String result, Instant timestamp) {
}
