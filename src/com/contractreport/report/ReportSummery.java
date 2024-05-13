package com.contractreport.report;

import com.contractreport.interfaces.ContractReportInterface;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ReportSummery implements Serializable, Cloneable {
    private static ReportSummery reportSummery;

    private ReportSummery() {
    }

    public static ReportSummery getInstance() {
        if (reportSummery == null) {
            synchronized (ReportSummery.class){
                if (reportSummery == null) {
                    reportSummery = new ReportSummery();
                }
            }
        }
        return reportSummery;
    }

    @Serial
    protected Object readResolve(){
        return reportSummery;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void report(ContractReportInterface contractReportService, ReportGeneratorInterface reportGeneratorInterface) {
        reportGeneratorInterface.generateReport(contractReportService);
    }

}
