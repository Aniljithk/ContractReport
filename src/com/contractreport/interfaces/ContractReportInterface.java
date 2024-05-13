package com.contractreport.interfaces;

import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

public interface ContractReportInterface {
    BuildDurationInterface getAverageBuildDurationQueryService();

    CustomersByContractInterface getCustomersByContractQueryService();

    CustomersByGeoZoneInterface getCustomersByGeoZoneService();
}
