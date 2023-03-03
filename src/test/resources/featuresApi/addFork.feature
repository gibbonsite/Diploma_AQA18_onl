@RegressionTest
Feature:

  Scenario: Add Fork repository
    When user post data of repository to fork
    Then user get response from git hub about added fork

