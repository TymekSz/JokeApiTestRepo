package requests;

import dto.JokeDto;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;

public class GetJokeByIdRequest {

    public JokeDto sendRequest(int jokeId) {
        return given()
                .spec(getRequestSpecBuilder())
                .get("jokes/" + jokeId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(JokeDto.class);
    }
}