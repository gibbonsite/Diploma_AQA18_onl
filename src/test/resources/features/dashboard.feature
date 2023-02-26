Feature: Dashboard

  @RegressionTest
  Scenario Outline: Pop-up window for repository list
    Given login page is opened
    And user with login "DiplomaAqa18Onl" and password "Aqa18OnlDipl#1" is logged in
    When user hovers over the "<repository>" repository in the repository list
    Then pop-up window with repository "<repository>" brief info appears
    Examples:
      | repository      |
      | FirstRepository |