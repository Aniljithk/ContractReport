package com.contractreport.service.report;

import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;

import java.util.*;

public class CustomersByContractReportService implements CustomersByContractInterface {

    Map<Integer, Set<Integer>> customerMap;

    public CustomersByContractReportService() {
        customerMap = new HashMap<>();
    }

    @Override
    public List<Integer> getContractors() {
        return List.copyOf(customerMap.keySet());
    }

    @Override
    public int getNumberOfCustomers(int contractID) {
        Set<Integer> customers = customerMap.get(contractID);
        if (customers != null) {
            return customers.size();
        }
        return 0;
    }

    @Override
    public void publishContract(ContractDetailInterface contractDetail) {
        Set<Integer> customers = customerMap.computeIfAbsent(contractDetail.getContractId(), contractId -> new HashSet<>());
        customers.add(contractDetail.getCustomerId());
    }


}
