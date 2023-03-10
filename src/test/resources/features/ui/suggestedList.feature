Feature: Suggested list

  @Ui @RegressionTest
  Scenario: Incorrect characters in suggested list name
    Given login page is opened
    And user with his login and password is logged in
    And user opens repository "FirstRepository" page
    When incorrect suggested list name is entered
    Then error message about incorrect suggested list name is shown
