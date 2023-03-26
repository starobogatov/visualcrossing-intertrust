package visualcrossing.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import visualcrossing.TestDataUtil;

public class WeatherDataApiTest {

    public static final String
            SEARCHABLE_LOCATION = "Tallinn",
            RESOLVED_ADDRESS = "Tallinn, Eesti";

    @Test(description = "Weather history successfully returned by location")
    public void getWeatherDataByLocation() {
        TestDataUtil testDataUtil = new TestDataUtil();
        Response response = testDataUtil
                .getWeatherDataByLocation(SEARCHABLE_LOCATION);

        ApiAssertions apiAssertions = new ApiAssertions(response);
        apiAssertions.assertJsonField("resolvedAddress", RESOLVED_ADDRESS);
        apiAssertions.assertJsonField("address", SEARCHABLE_LOCATION);
    }
}
