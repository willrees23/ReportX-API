package dev.wand.reportx.api.report;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ReportCache {

    private final Map<String, Report> cache = new ConcurrentHashMap<>();

    public Optional<Report> findById(String reportId) {
        return Optional.ofNullable(cache.get(reportId));
    }

    public void put(Report report) {
        cache.put(report.getId(), report);
    }

    public boolean isCached(String reportId) {
        return cache.containsKey(reportId);
    }

    public void remove(String reportId) {
        cache.remove(reportId);
    }

    public Map<String, Report> getAll() {
        return Map.copyOf(cache);
    }
}

