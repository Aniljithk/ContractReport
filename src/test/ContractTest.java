package test;

import com.contractreport.factory.ContractFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.model.ContractDetail;
import org.junit.Assert;
import org.junit.Test;

public class ContractTest {
    @Test
    public void createContractTest(){
        ContractDetailInterface project = createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000);
        Assert.assertEquals("Invalid Contract Customer Id", 2343225, project.getCustomerId());
        Assert.assertEquals("Invalid Contract Contract Id", 2345, project.getContractId());
        Assert.assertEquals("Invalid Build duration", 3000, project.getBuildDuration());
        Assert.assertEquals("Invalid Project Code ", "ProjectApple", project.getProjectCode());
        Assert.assertEquals("Invalid Geo Zone ", "us_east", project.getGeoZone());
        Assert.assertEquals("Invalid Team Code ", "RedTeam", project.getTeamCode());
    }
    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
