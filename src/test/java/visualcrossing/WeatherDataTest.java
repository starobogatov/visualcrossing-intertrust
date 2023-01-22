package visualcrossing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WeatherDataTest extends BaseTest {

    @Test(description = "Weather history successfully displayed on Visual Crossing page")
    public void viewWeatherData() {
        VisualCrossing
                .openVisualCrossingMainPage()
                .navigateToWeatherDataPage()
                .enterLocationAndSearchForWeatherData(LOCATION_CITY)
                .verifyWeatherHistoryByLocationIsDisplayed(LOCATION_CITY);
    }

    @AfterMethod
    public final void tearDown() {
        closeWebDriver();
    }
}
