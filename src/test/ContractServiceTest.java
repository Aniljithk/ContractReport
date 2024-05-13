package test;

import com.contractreport.factory.ContractFactory;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.service.ContractService;
import org.junit.Assert;
import org.junit.Test;

public class ContractServiceTest {
    @Test
    public void contractServiceReportTest(){
        ContractService contractService = new ContractService();
        contractService.addContract(createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        Assert.assertNotNull(contractService.getContractReport());
    }

    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
