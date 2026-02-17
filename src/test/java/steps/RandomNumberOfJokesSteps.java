package steps;

import dto.JokeDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requests.GetJokeByIdRequest;
import requests.GetRandomNumberOfJokesRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberOfJokesSteps {

    private JokeDto[] listOfJokes;
    private List<JokeDto> jokes;
    private List<JokeDto> expectedJokesById;

    @Given("Get random jokes as datatable")
    public void getSpecifiedNumberOfRandomJokesAsDataTable(DataTable dataTable) {
        jokes = dataTable.asList(JokeDto.class);
    }

    @When("Get jokes by id")
    public void getJokeById() {
        expectedJokesById = jokes.stream()
                .map(joke -> new GetJokeByIdRequest().sendRequest(joke.getId()))
                .toList();
    }

    @Then("Joke data is consistent")
    public void jokeDataIsConsistent() {
        assertThat(jokes).containsExactlyInAnyOrderElementsOf(expectedJokesById);
    }

    @When("Get {int} random jokes")
    public void getSpecifiedNumberOfRandomJokes(int numberOfJokes) {
        listOfJokes = new GetRandomNumberOfJokesRequest().sendRequest(numberOfJokes);
    }

    @Then("Number of jokes should be equal to: {int}")
    public void numberOfJokesShouldBeEqualTo(int numberOfJokes) {
        assertThat(listOfJokes.length).isEqualTo(numberOfJokes);
    }
}