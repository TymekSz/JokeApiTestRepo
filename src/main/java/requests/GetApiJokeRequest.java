package requests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetApiJokeRequest {

    public void sendRequest() {
        Response response = given()
                .spec(getRequestSpecBuilder())
                .get();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}