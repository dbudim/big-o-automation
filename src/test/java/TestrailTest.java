import com.big.o.api.tools.Result;
import com.big.o.api.tools.TestCase;
import com.big.o.api.tools.TestrailRestClient;
import okhttp3.ResponseBody;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by dbudim on 12.12.2021
 */

public class TestrailTest {

    public TestrailRestClient client = new TestrailRestClient();

    @Test
    public void testrailAPi() throws IOException {
        var s = client.results.getTests("1").execute().body();
    }
}
