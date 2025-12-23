package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Report {

    public Report(UUID creator, UUID target, String reason) {
        this(creator, target, reason, "global");
    }

    public Report(UUID creator, UUID target, String reason, String server) {
        this.id = randomId();
        this.creator = creator;
        this.target = target;
        this.reason = reason;
        this.server = server;
        this.dateTime = Instant.now();
        this.status = ReportStatus.PENDING;
    }

    private final String id;
    private final UUID creator, target;
    private final String reason;
    private final String server;
    @Setter
    private Instant dateTime;

    @Setter
    private Instant resolvedDateTime;
    @Setter
    private UUID resolvedBy, claimedBy;
    @Setter
    private String resolvedReason;
    @Setter
    private ReportStatus status;

    public Report(
            String id,
            UUID creator,
            UUID target,
            String reason,
            String server,
            Instant dateTime,
            ReportStatus status,
            UUID claimedBy,
            UUID resolvedBy,
            String resolvedReason,
            Instant resolvedDateTime
    ) {
        this.id = id;
        this.creator = creator;
        this.target = target;
        this.reason = reason;
        this.server = server;
        this.dateTime = dateTime;
        this.status = status;
        this.claimedBy = claimedBy;
        this.resolvedBy = resolvedBy;
        this.resolvedReason = resolvedReason;
        this.resolvedDateTime = resolvedDateTime;
    }


    private static String randomId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = ThreadLocalRandom.current().nextInt(chars.length());
            result.append(chars.charAt(index));
        }
        return result.toString();
    }
}
