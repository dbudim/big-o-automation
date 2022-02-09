package api.data_strictures_optimization;

import com.big.o.api.models.Launch;
import com.big.o.api.SpaceXRestClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class CheckNewFlightsInList {

    private SpaceXRestClient spaceXRestClient = new SpaceXRestClient();
    private Launch firstLaunch;
    private Launch secondLaunch;
    private Launch thirdLaunch;
    private Collection<Launch> launches;

    @BeforeClass
    public void prepareData() throws IOException {
        firstLaunch = spaceXRestClient.launchService.makeLaunch(60);
        secondLaunch = spaceXRestClient.launchService.makeLaunch(61);
        thirdLaunch = spaceXRestClient.launchService.makeLaunch(62);
        launches = spaceXRestClient.launchService.getAllLaunches().execute().body()
                .stream()
                .collect(Collectors.toList());
    }

    @Test
    public void checkFirstLaunchPresent() {
        assertTrue(launches.contains(firstLaunch), "launch isn't present");
    }

    @Test
    public void checkSecondLaunchPresent() {
        assertTrue(launches.contains(secondLaunch), "launch isn't present");
    }

    @Test
    public void checkThirdLaunchPresent() {
        assertTrue(launches.contains(thirdLaunch), "launch isn't present");
    }
}
