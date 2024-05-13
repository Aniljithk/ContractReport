package test.report;

import com.contractreport.factory.ContractFactory;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.BuildDurationInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BuildDurationServiceTest {
    @Test
    public void contractRepoTest(){
        BuildDurationInterface buildDuration = new ContractReportFactory().createBuildDurationInterface();

        buildDuration.publishContract(createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        buildDuration.publishContract(createContract(2343226, 2345, "us_west", "RedTeam", "ProjectApple", 1500));
        buildDuration.publishContract(createContract(2343227, 2346, "us_east", "RedTeam", "ProjectApple", 3500));

        Assert.assertEquals(Arrays.asList("us_west","us_east"), buildDuration.getGeoZones());
        Assert.assertEquals(1500, buildDuration.getAverageBuildDuration("us_west"));
        Assert.assertEquals(3250, buildDuration.getAverageBuildDuration("us_east"));
    }
    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
