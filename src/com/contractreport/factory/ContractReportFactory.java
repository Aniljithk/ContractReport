package com.contractreport.factory;

import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;
import com.contractreport.service.report.BuildDurationReportService;
import com.contractreport.service.report.ContractReportService;
import com.contractreport.service.report.CustomersByContractReportService;
import com.contractreport.service.report.CustomersByGeoZoneReportService;

public class ContractReportFactory implements ContractReportFactoryInterface {
    @Override
    public CustomersByGeoZoneInterface createCustomersByGeoZoneInterface() {
        return new CustomersByGeoZoneReportService();
    }

    @Override
    public CustomersByContractInterface createCustomersByContractInterface() {
        return new CustomersByContractReportService();
    }

    @Override
    public BuildDurationInterface createBuildDurationInterface() {
        return new BuildDurationReportService();
    }
}
