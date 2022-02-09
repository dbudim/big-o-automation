package api.login_cache;

import com.big.o.api.MockRestClient;
import org.testng.annotations.BeforeMethod;

public class FixtureMainUser {

    @BeforeMethod
    public void loginWithUser() {
        new MockRestClient().loginWithCache("some@gmail.com", "111111");
    }
}
