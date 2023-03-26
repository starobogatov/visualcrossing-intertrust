package visualcrossing;

import io.restassured.response.Response;
import visualcrossing.api.WeatherDataApi;

public class TestDataUtil {

    public Response getWeatherDataByLocation(String location) {
        WeatherDataApi weatherDataApi = new WeatherDataApi();
        Response response = weatherDataApi.getWeatherInformationByLocation(location);

        weatherDataApi.assertRequestCreated(response);
        return response;
    }
}
