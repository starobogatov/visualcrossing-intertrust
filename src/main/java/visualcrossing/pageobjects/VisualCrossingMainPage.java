package visualcrossing.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VisualCrossingMainPage extends BasePage {
    private static final SelenideElement
            headerWeather = $("h1 .text-nowrap"),
            menuOptionWeatherData = $("[href='/weather-data']");

    public static final String
            VISUAL_CROSSING_INFO_HEADER = "Weather Data & API";

    public VisualCrossingMainPage() {
        acceptCookies();
        headerWeather.shouldBe(visible)
                .shouldHave(text(VISUAL_CROSSING_INFO_HEADER));
    }

    @Step("Navigate to the weather data page")
    public WeatherDataPage navigateToWeatherDataPage() {
        menuOptionWeatherData
                .shouldBe(visible, enabled)
                .click();

        return new WeatherDataPage();
    }
}
