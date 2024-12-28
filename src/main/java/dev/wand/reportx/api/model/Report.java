package dev.wand.reportx.api.model;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

public record Report(UUID victim, UUID operator, String reason, Instant timestamp) {

    @Override
    public String toString() {
        return "Report{" +
                "victim=" + victim +
                ", operator=" + operator +
                ", reason='" + reason + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
