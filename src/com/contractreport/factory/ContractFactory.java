package com.contractreport.factory;

import com.contractreport.model.ContractDetail;

public class ContractFactory {
    public ContractDetail createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractDetail.ContractBuilder()
                .contractId(contractId)
                .customerId(customerId)
                .duration(buildDuration)
                .projectCode(projectCode)
                .teamCode(teamCode)
                .geoZone(geoZone)
                .build();
    }
}
