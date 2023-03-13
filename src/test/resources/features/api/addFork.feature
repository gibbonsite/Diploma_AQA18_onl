@Api @RegressionTest
Feature:

  Scenario: Add Fork repository
    When add information for database forks
    And user post data of repository to fork
    Then user get response from git hub about added fork

