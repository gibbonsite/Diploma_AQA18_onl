Feature: User status

  @RegressionTest
  Scenario: Set user status to 'busy'
    Given login page is opened
    And user with login "DiplomaAqa18Onl" and password "Aqa18OnlDipl#1" is logged in
    When user selects user status menu item
    Then user status dialog window appears
