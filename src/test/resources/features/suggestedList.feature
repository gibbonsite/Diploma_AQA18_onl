Feature: Suggested list

  @RegressionTest
  Scenario Outline: Incorrect characters in suggested list name
    Given login page is opened
    And user with login "<username>" and password "Aqa18OnlDipl#1" is logged in
    And user "<username>" opens repository "FirstRepository" page
    When incorrect suggested list name is entered
    Then error message about incorrect suggested list name is shown
    Examples:
      | username        |
      | DiplomaAqa18Onl |