package test;

import com.contractreport.engine.ReportSubscriber;
import com.contractreport.factory.ContractFactory;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;
import com.contractreport.service.ContractRepo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractRepoTest {
    @Test
    public void contractRepoTest(){
        List<ReportSubscriber> reportSubscribers = new ArrayList<>();
        CustomersByGeoZoneInterface customersByGeoZone = new ContractReportFactory().createCustomersByGeoZoneInterface();
        CustomersByContractInterface customersByContract = new ContractReportFactory().createCustomersByContractInterface();
        BuildDurationInterface buildDuration = new ContractReportFactory().createBuildDurationInterface();
        reportSubscribers.add(customersByGeoZone);
        reportSubscribers.add(customersByContract);
        reportSubscribers.add(buildDuration);

        ContractRepo repo = new ContractRepo(reportSubscribers);
        repo.addContract(createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        repo.addContract(createContract(2343226, 2345, "us_west", "RedTeam", "ProjectApple", 1500));
        repo.addContract(createContract(2343227, 2346, "us_east", "RedTeam", "ProjectApple", 3500));

        Assert.assertEquals(2, customersByGeoZone.getNumberOfCustomers("us_east"));
        Assert.assertEquals(Arrays.asList(2343225, 2343227), customersByGeoZone.getCustomers("us_east"));
        Assert.assertEquals(Arrays.asList("us_west","us_east"), customersByGeoZone.getGeoZones());

        Assert.assertEquals(Arrays.asList(2345, 2346), customersByContract.getContractors());
        Assert.assertEquals(1, customersByContract.getNumberOfCustomers(2346));

        Assert.assertEquals(Arrays.asList("us_west","us_east"), buildDuration.getGeoZones());
        Assert.assertEquals(1500, buildDuration.getAverageBuildDuration("us_west"));
        Assert.assertEquals(3250, buildDuration.getAverageBuildDuration("us_east"));
    }
    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
