package com.contractreport.report;

import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

public interface ReportGeneratorInterface {
    void generateReport(ContractReportInterface contractReportService);
    void generateReport(CustomersByContractInterface service);

    void generateReport(CustomersByGeoZoneInterface service);

    void generateReport(BuildDurationInterface service);
}
