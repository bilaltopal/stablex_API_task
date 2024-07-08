package org.stablex.stepdefinitions.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.stablex.stepdefinitions.hooks.BaseSteps;
import org.stablex.utils.ConfigManager;

public class DogBreeds extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(DogBreeds.class);

	Response response;

	@Given("I make a GET request to the {string} endpoint")
	public void ı_make_a_get_request_to_the_endpoint(String endpoint) {
		String url = ConfigManager.getProperty("base.uri") + endpoint;
		LOGGER.info("Making GET request to URL: {}", url);
		response = RestAssured.get(url);
	}

	@Then("the response status should be {string} status code")
	public void theResponseStatusShouldBeStatusCode(String expectedStatusCode) {
		Assertions.assertThat(response.getStatusCode()).isEqualTo(Integer.parseInt(expectedStatusCode));
		LOGGER.info("Checking if response status code <{}> matches expected status code <{}>", response.getStatusCode(),
				expectedStatusCode);

	}

}
