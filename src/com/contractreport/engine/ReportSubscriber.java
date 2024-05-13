package com.contractreport.engine;

import com.contractreport.interfaces.ContractDetailInterface;

public interface ReportSubscriber {
    void publishContract(ContractDetailInterface contractDetail);
}
