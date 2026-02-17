package stepdefinitions;

import dto.JokeDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requests.GetApiJokeRequest;
import requests.GetRandomJokeRequest;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JokeApiSteps {

    private Response response;

    @Given("Api is available")
    public void jokeApiIsAvailable() {
        new GetApiJokeRequest().sendRequest();
    }

    @When("Get random joke")
    public Response getRandomJoke() {
        response = new GetRandomJokeRequest().sendRequest();
        return response;
    }

    @Then("Schema should contains proper fields")
    public void assertFields() {
        var expectedFields = Arrays.stream(JokeDto.class.getDeclaredFields()).map(Field::getName).toList();
        var actualFields = response.jsonPath().getMap("$").keySet();

        assertThat(actualFields).containsExactlyInAnyOrderElementsOf(expectedFields);
    }

}