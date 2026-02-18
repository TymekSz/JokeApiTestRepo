package requests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;

public class GetRandomJokeRequest {

    public Response sendRequest() {
        return given()
                .spec(getRequestSpecBuilder())
                .get("random_joke")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}