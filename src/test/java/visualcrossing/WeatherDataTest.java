package visualcrossing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WeatherDataTest extends BaseTest {

    @Test
    public void viewWeatherData() {
        VisualCrossing
                .openVisualCrossingMainPage()
                .navigateToWeatherDataPage()
                .enterLocationAndSearchForWeatherData(LOCATION_CITY)
                .assertWeatherHistoryByLocation(LOCATION_CITY);
    }

    @AfterMethod
    public final void tearDown() {
        closeWebDriver();
    }
}
