package visualcrossing;

import visualcrossing.pageobjects.VisualCrossingMainPage;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static config.TestConfiguration.loadConfiguration;

public class VisualCrossing {
    private static final Properties properties = loadConfiguration();
    private static final String visualCrossingUrl = properties.getProperty("vc.url");

    public static VisualCrossingMainPage openVisualCrossingMainPage() {
        open(visualCrossingUrl);
        return new VisualCrossingMainPage();
    }
}
