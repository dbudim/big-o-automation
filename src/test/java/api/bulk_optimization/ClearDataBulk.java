package api.bulk_optimization;

import com.big.o.api.tools.Case;
import com.big.o.api.tools.DeleteCasesWrap;
import com.big.o.api.tools.TestrailRestClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by dbudim on 18.12.2021
 */

public class ClearDataBulk {

    private TestrailRestClient client = new TestrailRestClient();

    @Test(invocationCount = 20)
    public void createTestCaseTest() throws IOException {
        client.caseService.addCase(2, new Case(RandomStringUtils.randomAlphanumeric(16))).execute();
    }

    @AfterClass
    public void clearDataBulk() throws IOException {
        long start = System.currentTimeMillis();
        var cases = client.caseService.getCases(2, 1).execute().body()
                .cases
                .stream()
                .map(c -> c.id)
                .collect(Collectors.toList());
        client.caseService.deleteCases(2, new DeleteCasesWrap(cases, 2)).execute();
        long end = System.currentTimeMillis();
        System.out.println("Time bulk clear: " + (end - start));
    }

}
