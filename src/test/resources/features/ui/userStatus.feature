Feature: User status

  @Ui @RegressionTest
  Scenario: Set user status to 'busy'
    Given login page is opened
    And user with his login and password is logged in
    When user selects user status menu item
    Then user status dialog window appears
