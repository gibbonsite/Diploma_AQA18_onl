Feature: Dashboard

  @Ui @RegressionTest
  Scenario: Pop-up window for repository list
    Given login page is opened
    And user with his login and password is logged in
    When user hovers over the "FirstRepository" repository in the repository list
    Then pop-up window with repository brief info appears
