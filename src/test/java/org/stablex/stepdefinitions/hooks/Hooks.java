package org.stablex.stepdefinitions.hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class Hooks extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

	@Before
	public void setUp(@NotNull Scenario scenario) {
		LOGGER.info("::::::::::::::: TEST INFORMATION :::::::::::::::");
		LOGGER.info("Executing scenario: " + scenario.getName());
		Locale.setDefault(Locale.US);

	}

	@After
	public void tearDown(@NotNull Scenario scenario) {
		if (scenario.isFailed()) {
			if (response != null) {
				LOGGER.info("Scenario failed! Logging response body for failed scenario: " + scenario.getName());
				LOGGER.info(response.getBody().prettyPrint());
			}
			else {
				LOGGER.info("Scenario failed! But no response was set in the TestContext.");
			}
		}
		else {
			LOGGER.info("----------------- Scenario Successfully Passed -----------------");
		}

	}

}
