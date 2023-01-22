package visualcrossing.api;

import org.testng.annotations.Test;
import visualcrossing.TestDataUtil;

public class WeatherDataApiTest {

    public static final String
            SEARCHABLE_LOCATION = "Tallinn",
            RESOLVED_ADDRESS = "Tallinn, Eesti";

    @Test(description = "Weather history successfully returned by location")
    public void getWeatherDataByLocation() {
        TestDataUtil testDataUtil = new TestDataUtil();
        testDataUtil
                .getWeatherDataByLocation(
                        SEARCHABLE_LOCATION,
                        RESOLVED_ADDRESS
                );
    }
}
