package com.contractreport.report;

import com.contractreport.interfaces.ContractReportInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerator implements ReportGeneratorInterface {
    private void printResults(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void generateReport(ContractReportInterface contractReportService) {
        generateReport(contractReportService.getCustomersByContractQueryService());
        generateReport(contractReportService.getAverageBuildDurationQueryService());
        generateReport(contractReportService.getCustomersByGeoZoneService());

    }

    @Override
    public void generateReport(CustomersByContractInterface service) {
        System.out.println("======================================================\n");
        System.out.println("TASK : The number of unique customerId for each contractId\n");
        printResults(() -> {
            System.out.println("ContractorId"+String.format("%8s","")+"Number of customers");
            System.out.println("~~~~~~~~~~~~"+String.format("%8s","")+"~~~~~~~~~~~~~~~~~~~");
            for (int contractorId : service.getContractors()) {
                System.out.println(String.valueOf(contractorId)+String.format("%23s","")+String.valueOf(service.getNumberOfCustomers(contractorId)));
            }
            System.out.println("\n======================================================\n");
        });
    }

    @Override
    public void generateReport(CustomersByGeoZoneInterface service) {
        System.out.println("TASK : The number of unique customerId for each geozone\n");
        printResults(() -> {
            System.out.println("GeoZone"+String.format("%8s","")+"Number of customers");
            System.out.println("~~~~~~~"+String.format("%8s","")+"~~~~~~~~~~~~~~~~~~~");
            for (String geoZone : service.getGeoZones()) {
                System.out.println(String.valueOf(geoZone)+String.format("%15s","")+String.valueOf(service.getNumberOfCustomers(geoZone)));
            }
        });
        System.out.println("\n======================================================\n");

        System.out.println("TASK : The list of unique customerId for each geoZone\n");
        printResults(() -> {
            System.out.println("GeoZone"+String.format("%8s","")+"Customer Id's");
            System.out.println("~~~~~~~"+String.format("%8s","")+"~~~~~~~~~~~~~");
            for (String geoZone : service.getGeoZones()) {
                List<Integer> customers = service.getCustomers(geoZone);
                if (!customers.isEmpty()) {
                    System.out.println(geoZone+String.format("%9s","")+
                            customers.stream().map(Object::toString).collect(Collectors.joining(",")));
                }
            }
        });
        System.out.println("\n======================================================\n");
    }

    @Override
    public void generateReport(BuildDurationInterface service) {
        System.out.println("TASK : The average buildDuration for each geoZone\n");
        printResults(() -> {
            System.out.println("GeoZone"+String.format("%8s","")+"Average build duration( in seconds)");
            System.out.println("~~~~~~~"+String.format("%8s","")+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (String geoZone : service.getGeoZones()) {
                System.out.println(String.valueOf(geoZone)+String.format("%20s","")+String.valueOf(service.getAverageBuildDuration(geoZone)));
            }
        });
        System.out.println("\n======================================================\n");
    }
}
