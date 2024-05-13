package com.contractreport.interfaces.report;

import com.contractreport.engine.ReportSubscriber;

import java.util.List;

public interface CustomersByContractInterface extends ReportSubscriber {
    List<Integer> getContractors();
    int getNumberOfCustomers(int contractID);
}
