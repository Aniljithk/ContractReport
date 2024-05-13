package com.contractreport.service.report;

import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

public class ContractReportService implements ContractReportInterface {
    private final CustomersByGeoZoneInterface customersByGeo;
    private final CustomersByContractInterface customersByContract;
    private final BuildDurationInterface buildDurationQuery;

    public ContractReportService(CustomersByGeoZoneInterface reportByGeoZone, CustomersByContractInterface customersByContract,
                                 BuildDurationInterface buildDuration) {
        this.customersByGeo = reportByGeoZone;
        this.customersByContract = customersByContract;
        this.buildDurationQuery = buildDuration;
    }

    @Override
    public BuildDurationInterface getAverageBuildDurationQueryService() {
        return buildDurationQuery;
    }

    @Override
    public CustomersByContractInterface getCustomersByContractQueryService() {
        return customersByContract;
    }

    @Override
    public CustomersByGeoZoneInterface getCustomersByGeoZoneService() {
        return customersByGeo;
    }

}
