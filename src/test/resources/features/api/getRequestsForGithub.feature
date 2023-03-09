@Api @RegressionTest
Feature: Regression API Test

  Scenario: Data retrieval from github
    When authorization user want to get information from github
    Then the requested data is returned

  Scenario: Data request for all users
    When authorization user want to get all information from github
    Then the requested data info of all user is returned

  Scenario: Data request get emojis
    When authorization user want to get emojis information from github
    Then the requested data emojis is returned

  Scenario: Get emojis with double access token
    When authorization user want to get emojis with double access token
    Then the requester data return error unauthorization error

  Scenario: Get wrong endpoint when get user by username
    When authorization user want to get information from github with wrong endpoint
    Then the requester data return error not found error
