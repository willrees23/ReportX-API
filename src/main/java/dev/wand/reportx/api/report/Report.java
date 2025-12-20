package dev.wand.reportx.api.report;

import dev.wand.reportx.api.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
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
        this.server = "global";
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

    private String randomId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder(6);
        for (int i = 0; i < 6; i++) { // loop exactly 6 times
            int index = ThreadLocalRandom.current().nextInt(chars.length());
            result.append(chars.charAt(index));
        }
        return result.toString();
    }


    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("creator", creator);
        map.put("target", target);
        map.put("reason", reason);
        map.put("server", server);
        map.put("dateTime", dateTime != null ? dateTime.toString() : null);
        map.put("resolvedDateTime", resolvedDateTime != null ? resolvedDateTime.toString() : null);
        map.put("resolvedBy", resolvedBy);
        map.put("resolvedReason", resolvedReason);
        map.put("status", status != null ? status.name() : null);
        return map;
    }

    public static Report deserialize(Map<String, Object> map) {
        Report report = new Report(
                (String) map.get("creator"),
                (String) map.get("target"),
                (String) map.get("reason"),
                (String) map.getOrDefault("server", "global")
        );

        // Use reflection or setters to fill additional fields
        report.dateTime = map.get("dateTime") != null ? Instant.parse((String) map.get("dateTime")) : Instant.now();
        report.resolvedDateTime = map.get("resolvedDateTime") != null ? Instant.parse((String) map.get("resolvedDateTime")) : null;
        report.resolvedBy = (String) map.get("resolvedBy");
        report.resolvedReason = (String) map.get("resolvedReason");
        if (map.get("status") != null) {
            report.status = ReportStatus.valueOf((String) map.get("status"));
        }
        // Override the generated id with the serialized one
        try {
            java.lang.reflect.Field idField = Report.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(report, map.get("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return report;
    }
}
