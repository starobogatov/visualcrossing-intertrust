package visualcrossing.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {

    public static RequestSpecification givenWithBaseUri(String url) {
        return given().baseUri(url);
    }

    public void assertRequestCreated(Response response) {
        new ApiAssertions(response).assertResponseCode(200);
    }
}
