package steps;

import dto.JokeDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requests.GetRandomNumberOfJokesRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberOfJokesSteps {

    private JokeDto[] listOfJokes;

    @When("Get {int} random jokes")
    public void getSpecifiedNumberOfRandomJokes(int numberOfJokes) {
        listOfJokes = new GetRandomNumberOfJokesRequest().sendRequest(numberOfJokes);
    }

    @Then("Number of jokes should be equal to: {int}")
    public void numberOfJokesShouldBeEqualTo(int numberOfJokes) {
        assertThat(listOfJokes.length).isEqualTo(numberOfJokes);
    }
}