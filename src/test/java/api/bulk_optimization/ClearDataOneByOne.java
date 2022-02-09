package api.bulk_optimization;

import com.big.o.api.tools.Case;
import com.big.o.api.tools.TestrailRestClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class ClearDataOneByOne {

    private TestrailRestClient client = new TestrailRestClient();

    @Test(invocationCount = 20)
    public void createTestCaseTest() throws IOException {
        client.caseService.addCase(2, new Case(RandomStringUtils.randomAlphanumeric(16))).execute();
    }

    @AfterClass
    public void clearData() throws IOException {
        long start = System.currentTimeMillis();
        var cases = client.caseService.getCases(2, 1).execute().body().cases;

        for (var c : cases) {
            client.caseService.deleteCase(c.id).execute();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time one by one clear: " + (end - start));
    }
}
