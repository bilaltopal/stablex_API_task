package org.stablex.stepdefinitions.hooks;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.stablex.utils.ConfigManager;

import static io.restassured.RestAssured.baseURI;

public class BaseSteps {

	protected static Response response;

	protected static RequestSpecification request;

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");

	}

}
