package dev.wand.reportx.api.report.repository;

import dev.wand.reportx.api.enums.ReportStatus;
import dev.wand.reportx.api.report.Report;
import dev.wand.reportx.api.report.ReportCache;

import java.util.List;
import java.util.Optional;

public abstract class CachedReportRepository implements ReportRepository {

    protected final ReportCache cache;

    public CachedReportRepository(ReportCache cache) {
        this.cache = cache;
    }

    @Override
    public Report save(Report report) {
        Report saved = saveToStorage(report);
        cache.put(saved);
        return saved;
    }

    @Override
    public Optional<Report> findById(String reportId) {
        if (cache.isCached(reportId)) {
            return cache.findById(reportId);
        }
        Report report = fetchFromStorageById(reportId);
        if (report != null) cache.put(report);
        return Optional.ofNullable(report);
    }

    @Override
    public List<Report> findByStatus(ReportStatus status) {
        List<Report> cached = cache.getAll().values().stream()
                .filter(r -> r.getStatus() == status)
                .toList();
        if (!cached.isEmpty()) return cached;

        List<Report> fetched = fetchFromStorageByStatus(status);
        fetched.forEach(cache::put);
        return fetched;
    }

    @Override
    public void updateStatus(String reportId, String staffUuid, String reason, ReportStatus status) {
        updateStatusInStorage(reportId, staffUuid, reason, status);
        cache.findById(reportId).ifPresent(r -> {
            r.setStatus(status);
            r.setResolvedBy(staffUuid);
            r.setResolvedReason(reason);
        });
    }

    // Abstract methods for concrete repositories
    protected abstract Report saveToStorage(Report report);

    protected abstract Report fetchFromStorageById(String reportId);

    protected abstract List<Report> fetchFromStorageByStatus(ReportStatus status);

    protected abstract void updateStatusInStorage(String reportId, String staffUuid, String reason, ReportStatus status);
}
