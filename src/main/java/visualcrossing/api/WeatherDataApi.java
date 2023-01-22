package visualcrossing.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Properties;

import static config.TestConfiguration.loadConfiguration;
import static io.restassured.http.ContentType.JSON;

public class WeatherDataApi extends BaseApi {
    private static final Properties properties = loadConfiguration();
    private static final String
            visualCrossingApiUrl = properties.getProperty("vc.api.url"),
            visualCrossingApiKey = properties.getProperty("vc.api.key");

    @Step("Get weather information by location: {city} using API ")
    public Response getWeatherInformationByLocation(String city) {
        return givenWithBaseUri(visualCrossingApiUrl).log().all()
                .pathParam("city", city)
                .pathParam("apiKey", visualCrossingApiKey)
                .when().get("VisualCrossingWebServices/rest/services/timeline/" +
                        "{city}?unitGroup=metric&key={apiKey}&contentType=json")
                .then().contentType(JSON)
                .extract().response();
    }
}
