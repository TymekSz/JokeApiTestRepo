package requests;

import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;

public class GetApiJokeRequest {

    public void sendRequest() {
        given()
                .spec(getRequestSpecBuilder())
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}