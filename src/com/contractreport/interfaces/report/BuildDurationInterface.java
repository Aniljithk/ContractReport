package com.contractreport.interfaces.report;

import com.contractreport.engine.ReportSubscriber;

import java.util.List;

public interface BuildDurationInterface extends ReportSubscriber {
    List<String> getGeoZones();

    long getAverageBuildDuration(String geoZone);
}
