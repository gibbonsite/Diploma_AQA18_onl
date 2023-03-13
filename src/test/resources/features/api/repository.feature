@Api @SmokeTest
Feature: Smoke Test

  Scenario: Create repository from Github
    When user add repository to database
    And user post data to github api
    Then user check code status

  Scenario: User send get request about repository Github
    When user get repo data to github api
    Then user get response from github about created repository
    And Delete repository


