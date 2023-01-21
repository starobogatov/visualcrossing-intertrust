package visualcrossing.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WeatherHistoryPage extends BasePage {
    private static final SelenideElement
            pageHeader = $("h1"),
            summaryLocationSpecific = $("#weatherSummary");

    public WeatherHistoryPage() {
        summaryLocationSpecific
                .shouldBe(visible);
    }

    public WeatherHistoryPage assertWeatherHistoryByLocation(String location) {
        assertHeaderContainsLocationName(location);
        assertDateRangeHeaderContainsLocationName(location);
        assertWeatherHistoryTableIsVisibleByLocation();

        return this;
    }

    private static SelenideElement assertHeaderContainsLocationName(String location) {
        return pageHeader
                .shouldBe(visible)
                .shouldHave(text(location));
    }

    private static SelenideElement assertDateRangeHeaderContainsLocationName(String location) {
        return summaryLocationSpecific
                .$("#locationDropdownMenuButton")
                .shouldBe(visible)
                .shouldHave(text(location));
    }

    private static SelenideElement assertWeatherHistoryTableIsVisibleByLocation() {
        return summaryLocationSpecific
                .$(".maingrid").as("weather history graph/table")
                .shouldBe(visible);
    }
}
