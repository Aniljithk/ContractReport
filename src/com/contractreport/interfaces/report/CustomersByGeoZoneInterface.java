package com.contractreport.interfaces.report;

import com.contractreport.engine.ReportSubscriber;

import java.util.List;

public interface CustomersByGeoZoneInterface extends ReportSubscriber {
    List<Integer> getCustomers(String geoZone);

    int getNumberOfCustomers(String geoZone);

    List<String> getGeoZones();
}
