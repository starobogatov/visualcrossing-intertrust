package visualcrossing.api;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ApiAssertions extends BaseApi {
    protected final Response response;

    public ApiAssertions(Response response) {
        this.response = response;
    }

    public void assertResponseCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    public void assertJsonField(String field, String expectedValue) {
        response.then().assertThat().body(field, equalTo(expectedValue));
    }
}
