package requests;

import dto.JokeDto;
import org.apache.http.HttpStatus;

import static helpers.RequestSpecBuilderProvider.getRequestSpecBuilder;
import static io.restassured.RestAssured.given;

public class GetRandomNumberOfJokesRequest {

    public JokeDto[] sendRequest(int numberOfJokes) {
        return given()
                .spec(getRequestSpecBuilder())
                .get("jokes/random/" + numberOfJokes).then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(JokeDto[].class);
    }
}