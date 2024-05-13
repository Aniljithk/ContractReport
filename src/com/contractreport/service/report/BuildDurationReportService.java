package com.contractreport.service.report;

import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildDurationReportService implements BuildDurationInterface {


    private final Map<String, Duration> buildDurationMap;

    public BuildDurationReportService() {
        buildDurationMap = new HashMap<>();
    }

    @Override
    public long getAverageBuildDuration(String geoZone) {
        Duration duration = buildDurationMap.get(geoZone);
        if (duration != null) {
            return duration.getAverage();
        }
        return 0;
    }

    @Override
    public void publishContract(ContractDetailInterface contractDetail) {
        Duration duration = buildDurationMap.computeIfAbsent(contractDetail.getGeoZone(), key -> new Duration());
        duration.addDuration(contractDetail.getBuildDuration());
    }

    @Override
    public List<String> getGeoZones() {
        return List.copyOf(buildDurationMap.keySet());
    }

    static class Duration {
        private int count = 0;
        private long duration = 0;

        long getAverage() {
            return duration / count;
        }

        public void addDuration(long duration) {
            this.duration += duration;
            count++;
        }
    }

}
