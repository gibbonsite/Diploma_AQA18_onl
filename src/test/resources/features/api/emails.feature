@Api @SmokeTest
Feature: Email Test

  Scenario: Add email address to github account
    When Add information for db email
    And user post email address for github
    Then user get response from github about email address is added

  Scenario: User send get request to github
    Then user send get response to github
    And check get status
    And delete added email