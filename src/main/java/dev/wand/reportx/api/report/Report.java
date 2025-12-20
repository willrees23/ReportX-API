package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Report {

    public Report(String creator, String target, String reason) {
        this(creator, target, reason, "global");
    }

    public Report(String creator, String target, String reason, String server) {
        this.id = randomId();
        this.creator = creator;
        this.target = target;
        this.reason = reason;
        this.server = server;
        this.dateTime = Instant.now();
    }

    private final String id;
    private final String creator;
    private final String target;
    private final String reason;
    private final String server;
    @Setter
    private Instant dateTime;

    @Setter
    private Instant resolvedDateTime;
    @Setter
    private String resolvedBy, resolvedReason;
    @Setter
    private ReportStatus status;


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
