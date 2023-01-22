package visualcrossing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import static config.TestConfiguration.loadConfiguration;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Long.parseLong;

public class BaseTest {

    public static final String LOCATION_CITY = "Tallinn";

    @BeforeClass
    public final void setupSelenide() {
        Properties properties = loadConfiguration();
        String selenideBrowser = properties.getProperty("selenide.browser");

        String chromeOptionsArguments = "" +
                "--incognito, " +
                "--disable-infobars, " +
                "--enable-automation, " +
                "--disable-browser-side-navigation, " +
                "--lang=en-US";

        System.setProperty("chromeoptions.args", chromeOptionsArguments);
        System.setProperty("chromeoptions.prefs", "disable-features=NetworkService");
        Configuration.headless = parseBoolean(properties.getProperty("selenide.headless"));
        Configuration.browser = selenideBrowser;
        Configuration.browserSize = "1400x864";
        Configuration.pageLoadTimeout = parseLong(properties.getProperty("selenide.timeout"));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }
}
