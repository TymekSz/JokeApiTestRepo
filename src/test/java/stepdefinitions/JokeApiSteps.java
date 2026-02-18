package stepdefinitions;

import dto.JokeDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requests.GetApiJokeRequest;
import requests.GetJokeByIdRequest;
import requests.GetRandomJokeRequest;
import requests.GetRandomNumberOfJokesRequest;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JokeApiSteps {

    private Response response;
    private JokeDto[] listOfJokes;
    private List<JokeDto> jokes;
    private List<JokeDto> expectedJokesById;

    @Given("Api is available")
    public void jokeApiIsAvailable() {
        new GetApiJokeRequest().sendRequest();
    }

    @When("Get random joke")
    public Response getRandomJoke() {
        response = new GetRandomJokeRequest().sendRequest();
        return response;
    }

    @When("Get random jokes as datatable")
    public void getSpecifiedNumberOfRandomJokesAsDataTable(DataTable dataTable) {
        jokes = dataTable.asList(JokeDto.class);
    }

    @When("Get jokes by id")
    public void getJokeById() {
        expectedJokesById = jokes.stream()
                .map(joke -> new GetJokeByIdRequest().sendRequest(joke.getId()))
                .toList();
    }

    @When("Get {int} random jokes")
    public void getSpecifiedNumberOfRandomJokes(int numberOfJokes) {
        listOfJokes = new GetRandomNumberOfJokesRequest().sendRequest(numberOfJokes);
    }

    @Then("Schema should contains proper fields")
    public void assertFields() {
        var expectedFields = Arrays.stream(JokeDto.class.getDeclaredFields())
                .map(Field::getName)
                .toList();

        var actualFields = response.jsonPath()
                .getMap("$")
                .keySet();

        assertThat(actualFields).containsExactlyInAnyOrderElementsOf(expectedFields);
    }

    @Then("Joke data is consistent")
    public void jokeDataIsConsistent() {
        assertThat(jokes).containsExactlyInAnyOrderElementsOf(expectedJokesById);
    }

    @Then("Number of jokes should be equal to: {int}")
    public void numberOfJokesShouldBeEqualTo(int numberOfJokes) {
        assertThat(listOfJokes.length).isEqualTo(numberOfJokes);
    }
}