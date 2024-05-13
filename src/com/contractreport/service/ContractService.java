package com.contractreport.service;

import com.contractreport.engine.ReportSubscriber;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.factory.ContractReportFactoryInterface;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.ContractRepoInterface;
import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;
import com.contractreport.service.report.ContractReportService;

import java.util.ArrayList;
import java.util.List;

public class ContractService {
    private final ContractRepoInterface contractRepo;
    private final ContractReportInterface contractReport;

    public ContractService() {
        ContractReportFactoryInterface reportFactory = new ContractReportFactory();
        CustomersByGeoZoneInterface customersByGeoZone = reportFactory.createCustomersByGeoZoneInterface();
        CustomersByContractInterface customersByContract = reportFactory.createCustomersByContractInterface();
        BuildDurationInterface buildDuration = reportFactory.createBuildDurationInterface();

        contractReport = createReport(customersByGeoZone, customersByContract, buildDuration);

        List<ReportSubscriber> reportSubscribers = new ArrayList<>();
        reportSubscribers.add(customersByGeoZone);
        reportSubscribers.add(customersByContract);
        reportSubscribers.add(buildDuration);
        contractRepo = createContractsRepo(reportSubscribers);
    }

    public void addContract(ContractDetailInterface contractDetail) {
        contractRepo.addContract(contractDetail);
    }

    private ContractRepoInterface createContractsRepo(List<ReportSubscriber> reportSubscribers) {
        return new ContractRepo(reportSubscribers);
    }

    private ContractReportInterface createReport(CustomersByGeoZoneInterface reportByGeoZone,
                                                CustomersByContractInterface reportByContract,
                                                BuildDurationInterface reportByBuildDuration) {
        return new ContractReportService(reportByGeoZone, reportByContract, reportByBuildDuration);
    }

    public ContractReportInterface getContractReport() {
        return contractReport;
    }
}
