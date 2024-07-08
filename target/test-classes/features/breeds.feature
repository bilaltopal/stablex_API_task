# Created by Bilal TOPAL at 8.07.2024
# Description: The task given by Stablex is that;
# Send GET request to https://dogapi.dog/api/v2/breeds endpoint
# Verify response status is 200 OK

@breeds
Feature: Retrieve Dog Breeds List
  As a user of the dog API
  I want to retrieve a list of dog breeds
  So that I can ensure the API is functioning correctly
  Scenario: Successful retrieval of dog breeds
    Given I make a GET request to the '/api/v2/breeds' endpoint
    Then the response status should be '200' status code



