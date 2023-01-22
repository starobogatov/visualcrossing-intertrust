package visualcrossing;

import io.qameta.allure.Step;
import logging.Log;
import visualcrossing.pageobjects.VisualCrossingMainPage;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static config.TestConfiguration.loadConfiguration;

public class VisualCrossing {
    private static final Properties properties = loadConfiguration();
    private static final String visualCrossingUrl = properties.getProperty("vc.url");

    @Step("Open visual crossing weather page")
    public static VisualCrossingMainPage openVisualCrossingMainPage() {
        open(visualCrossingUrl);
        Log.info("Opening URL: {}",  visualCrossingUrl);
        return new VisualCrossingMainPage();
    }
}
