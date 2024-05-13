package test.report;

import com.contractreport.factory.ContractFactory;
import com.contractreport.factory.ContractReportFactory;
import com.contractreport.interfaces.ContractDetailInterface;
import com.contractreport.interfaces.report.CustomersByContractInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CustomersByContractServiceTest {
    @Test
    public void contractRepoTest(){
        CustomersByContractInterface customersByContract = new ContractReportFactory().createCustomersByContractInterface();

        customersByContract.publishContract(createContract(2343225, 2345, "us_east", "RedTeam", "ProjectApple", 3000));
        customersByContract.publishContract(createContract(2343226, 2345, "us_west", "RedTeam", "ProjectApple", 1500));
        customersByContract.publishContract(createContract(2343227, 2346, "us_east", "RedTeam", "ProjectApple", 3500));

        Assert.assertEquals(Arrays.asList(2345, 2346), customersByContract.getContractors());
        Assert.assertEquals(1, customersByContract.getNumberOfCustomers(2346));

    }
    private ContractDetailInterface createContract(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new ContractFactory().createContract(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
