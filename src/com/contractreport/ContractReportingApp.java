package com.contractreport;

import com.contractreport.factory.ContractFactory;
import com.contractreport.input.InputFile;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.report.ReportGenerator;
import com.contractreport.report.ReportSummery;
import com.contractreport.service.ContractService;

import java.util.List;

public class ContractReportingApp {
    public static void main(String[] args) {
        System.out.println("****************************************************************");
        System.out.println("*********** Starting with Contract Report Generation *********** \n");
        ContractService contractService = new ContractService();
        ContractFactory contractFactory = new ContractFactory();
        List<String> inputData = InputFile.getContractData();
        inputData.forEach(contractInfo -> {
            ContractDetailInterface contract = createContractRecord(contractFactory, contractInfo);
            if (contract != null) {
                contractService.addContract(contract);
            }
        });

        ReportSummery.getInstance().report(contractService.getContractReport(), new ReportGenerator());

        System.out.println("*********** Contract Report Generation Completed ***********");
        System.out.println("**************************************************************** \n");
    }

    private static ContractDetailInterface createContractRecord(ContractFactory contractFactory, String contractInfo) {
        String[] contractInformation = contractInfo.split(",");
        if (contractInformation.length != 6) {
            return null;
        }
        try {
            int customerId = Integer.parseInt(contractInformation[0]);
            int contractorId = Integer.parseInt(contractInformation[1]);
            String geoZone = contractInformation[2];
            String teamCode = contractInformation[3];
            String projectCode = contractInformation[4];
            String durationStr = contractInformation[5];
            long duration = Long.parseLong(durationStr.substring(0, durationStr.length() - 1));
            return contractFactory.createContract(customerId, contractorId, geoZone, teamCode, projectCode, duration);
        } catch (Exception ex) {
            System.out.println("Invalid Contract Input Received with data :" + contractInfo);
        }
        return null;

    }
}
