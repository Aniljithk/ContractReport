package com.contractreport.model;

import com.contractreport.interfaces.ContractDetailInterface;

public class ContractDetail implements ContractDetailInterface {

    private final int customerId;
    private final int contractId;
    private final String geoZone;
    private final String teamCode;
    private final String projectCode;
    private final long duration;

    public ContractDetail(ContractBuilder contractBuilder) {
        this.customerId = contractBuilder.customerId;
        this.contractId = contractBuilder.contractId;
        this.geoZone = contractBuilder.geoZone;
        this.teamCode = contractBuilder.teamCode;
        this.projectCode = contractBuilder.projectCode;
        this.duration = contractBuilder.duration;
    }

    public static class ContractBuilder{
        private int customerId;
        private int contractId;
        private String geoZone;
        private String teamCode;
        private String projectCode;
        private long duration;

        public ContractBuilder customerId(int customerId){
            this.customerId = customerId;
            return this;
        }
        public ContractBuilder contractId(int contractId){
            this.contractId = contractId;
            return this;
        }
        public ContractBuilder geoZone(String geoZone){
            this.geoZone = geoZone;
            return this;
        }
        public ContractBuilder teamCode(String teamCode){
            this.teamCode = teamCode;
            return this;
        }public ContractBuilder projectCode(String projectCode){
            this.projectCode = projectCode;
            return this;
        }public ContractBuilder duration(long duration){
            this.duration = duration;
            return this;
        }
        public ContractDetail build() {
            return new ContractDetail(this);
        }
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public int getContractId() {
        return contractId;
    }

    @Override
    public String getGeoZone() {
        return geoZone;
    }

    @Override
    public String getTeamCode() {
        return teamCode;
    }

    @Override
    public String getProjectCode() {
        return projectCode;
    }

    @Override
    public long getBuildDuration() {
        return duration;
    }
}
