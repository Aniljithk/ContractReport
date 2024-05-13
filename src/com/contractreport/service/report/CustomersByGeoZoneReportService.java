package com.contractreport.service.report;

import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

import java.util.*;

public class CustomersByGeoZoneReportService implements CustomersByGeoZoneInterface {

    private final Map<String, Set<Integer>> customerMap;

    public CustomersByGeoZoneReportService() {
        customerMap = new HashMap<>();
    }

    @Override
    public List<Integer> getCustomers(String geoZone) {
        Set<Integer> customerList = customerMap.get(geoZone);
        if (customerList != null) {
            List<Integer> list = new ArrayList<>(customerList);
            Collections.sort(list);
            return list;
        }
        return Collections.emptyList();
    }

    @Override
    public int getNumberOfCustomers(String geoZone) {
        Set<Integer> customerList = customerMap.getOrDefault(geoZone, new HashSet<>());
        return customerList.size();
    }

    @Override
    public void publishContract(ContractDetailInterface contractDetail) {
        Set<Integer> customerList = customerMap.computeIfAbsent(contractDetail.getGeoZone(), geoZone -> new HashSet<>());
        customerList.add(contractDetail.getCustomerId());
    }

    @Override
    public List<String> getGeoZones() {
        return List.copyOf(customerMap.keySet());
    }

}
