package com.contractreport.service;

import com.contractreport.engine.ReportSubscriber;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.ContractRepoInterface;

import java.util.ArrayList;
import java.util.List;

public class ContractRepo implements ContractRepoInterface {
    private final List<ContractDetailInterface> contractList;
    private final List<ReportSubscriber> reportSubscribers;

    public ContractRepo(List<ReportSubscriber> reportSubscribers) {
        this.contractList = new ArrayList<>();
        this.reportSubscribers = reportSubscribers;
    }

    @Override
    public void addContract(ContractDetailInterface contractDetail) {
        contractList.add(contractDetail);
        reportSubscribers.forEach(reportEngine -> reportEngine.publishContract(contractDetail));
    }
}
