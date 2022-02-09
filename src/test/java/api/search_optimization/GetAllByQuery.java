package api.search_optimization;

import com.big.o.api.SpaceXRestClient;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetAllByQuery {

    private SpaceXRestClient spaceXRestClient = new SpaceXRestClient();

    @Test
    public void getLaunchWithQuery() throws IOException {
        var launch = spaceXRestClient.launchService.getAllLaunches(60).execute().body()
                .stream()
                .filter(l -> l.getFlight_number().equals(60))
                .findFirst()
                .orElseThrow(() -> new AssertionError("launch not found"));
        assertEquals(launch.mission_name, "TESS", "mission doesn't match");
    }

}
