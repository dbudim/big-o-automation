package api.search_optimization;

import com.big.o.api.SpaceXRestClient;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetAllAndFilter {

    private SpaceXRestClient spaceXRestClient = new SpaceXRestClient();

    @Test
    public void getLaunchAndFilter() throws IOException {
        var launches = spaceXRestClient.launchService.getAllLaunches().execute().body()
                .stream()
                .filter(launch -> launch.getFlight_number().equals(60))
                .findFirst()
                .orElseThrow(() -> new AssertionError("launch not found"));
        assertEquals(launches.mission_name, "TESS","mission doesn't match");
    }

}
