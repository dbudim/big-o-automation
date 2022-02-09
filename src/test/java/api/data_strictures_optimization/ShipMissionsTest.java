package api.data_strictures_optimization;

import com.big.o.api.models.Ship;
import com.big.o.api.SpaceXRestClient;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class ShipMissionsTest {

    private SpaceXRestClient spaceXRestClient = new SpaceXRestClient();
    private Ship ship;
    private List<Ship.Mission> missions;
    private Map<String, Integer> missionsDataMap;

    @BeforeClass
    public void prepareData() throws IOException {
        ship = spaceXRestClient.shipsService.getShip("OCISLY").execute().body();
        missions = ship.missions;

        missionsDataMap = ship
                .missions
                .stream()
                .collect(Collectors.toMap(mission -> mission.name, mission -> mission.flight));
    }

    @Test
    public void checkShipMissions() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(getMissionFlight("SES-9"), 27, "SES-9 flight doesn't match");
        sa.assertEquals(getMissionFlight("CRS-8"), 28, "CRS-8 flight doesn't match");
        sa.assertEquals(getMissionFlight("TESS"), 60, "TESS flight doesn't match");
        sa.assertEquals(getMissionFlight("Starlink v0.9"), 79, "Starlink v0.9 flight doesn't match");
        sa.assertAll();
    }

    @Test
    public void checkShipMissionsOptimized() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(getMissionFlightOptimized("SES-9"), 27, "SES-9 flight doesn't match");
        sa.assertEquals(getMissionFlightOptimized("CRS-8"), 28, "CRS-8 flight doesn't match");
        sa.assertEquals(getMissionFlightOptimized("TESS"), 60, "TESS flight doesn't match");
        sa.assertEquals(getMissionFlightOptimized("Starlink v0.9"), 79, "Starlink v0.9 flight doesn't match");
        sa.assertAll();
    }


    private int getMissionFlight(String name) {
        return missions
                .stream()
                .filter(mission -> mission.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError(String.format("mission [%s] not found", name)))
                .flight
                .intValue();
    }

    private int getMissionFlightOptimized(String name) {
        Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
        return missionsDataMap.get(name);
    }

}
