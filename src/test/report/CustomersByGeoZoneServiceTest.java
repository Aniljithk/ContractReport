package test.report;

import com.contractreport.factory.ContractFactory;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.CustomersByGeoZoneInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CustomersByGeoZoneServiceTest {
    @Test
    public void contractRepoTest(){
        CustomersByGeoZoneInterface customersByGeoZone = new ContractReportFactory().createCustomersByGeoZoneInterface();

        customersByGeoZone.publishContract(createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        customersByGeoZone.publishContract(createContract(2343226, 2345, "us_west", "RedTeam", "ProjectApple", 1500));
        customersByGeoZone.publishContract(createContract(2343227, 2346, "us_east", "RedTeam", "ProjectApple", 3500));

        Assert.assertEquals(2, customersByGeoZone.getNumberOfCustomers("us_east"));
        Assert.assertEquals(Arrays.asList(2343225, 2343227), customersByGeoZone.getCustomers("us_east"));
        Assert.assertEquals(Arrays.asList("us_west","us_east"), customersByGeoZone.getGeoZones());

    }
    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
