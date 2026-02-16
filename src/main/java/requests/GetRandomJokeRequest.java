package requests;

import dto.JokeDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetRandomJokeRequest {

    public JokeDto sendRequest() {
        Response response = given()
                .spec(getRequestSpecBuilder())
                .get("random_joke");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        return response.as(JokeDto.class);
    }
}