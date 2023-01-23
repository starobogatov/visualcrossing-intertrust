package visualcrossing.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WeatherDataPage extends BasePage {
    private static final ElementsCollection
            headersWeather = $$("h1 .text-nowrap");

    private static final SelenideElement
            formSearchWeatherByLocation = $("#wxdataform"),
            fieldEnterLocation = $("#wxlocation");

    public WeatherDataPage() {
        headersWeather
                .findBy(text("Total Weather Data"))
                .shouldBe(visible);
    }

    @Step("Search for weather history by location: {location}")
    public WeatherHistoryPage enterLocationAndSearchForWeatherData(String location) {
        fieldEnterLocation.shouldBe(visible, enabled)
                .setValue(location);

        clickSearchButton();

        return new WeatherHistoryPage();
    }

    private static void clickSearchButton() {
        formSearchWeatherByLocation
                .shouldBe(visible)
                .$(".btn-primary").as("button 'search by location'")
                .click();
    }
}
