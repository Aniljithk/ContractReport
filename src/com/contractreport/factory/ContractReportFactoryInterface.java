package com.contractreport.factory;

import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

public interface ContractReportFactoryInterface {

    CustomersByGeoZoneInterface createCustomersByGeoZoneInterface();

    CustomersByContractInterface createCustomersByContractInterface();

    BuildDurationInterface createBuildDurationInterface();
}
