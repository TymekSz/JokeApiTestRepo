package requests;

import dto.JokeDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetJokeByIdRequest {

    public JokeDto sendRequest(int jokeId) {
        Response response = given()
                .spec(getRequestSpecBuilder())
                .get("jokes/" + jokeId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        return response.as(JokeDto.class);
    }
}