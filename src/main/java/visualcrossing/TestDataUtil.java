package visualcrossing;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import logging.Log;
import visualcrossing.api.ApiAssertions;
import visualcrossing.api.WeatherDataApi;

public class TestDataUtil {

    public void getWeatherDataByLocation(String location, String resolvedAddress) {
        WeatherDataApi weatherDataApi = new WeatherDataApi();
        Response response = weatherDataApi.getWeatherInformationByLocation(location);

        ResponseBody responseBody = response.body();
        Log.info("Response body is {}",  responseBody.asString());

        weatherDataApi.assertRequestCreated(response);
        ApiAssertions apiAssertions = new ApiAssertions(response);
        apiAssertions.assertJsonField("resolvedAddress", resolvedAddress);
        apiAssertions.assertJsonField("address", location);
    }
}
