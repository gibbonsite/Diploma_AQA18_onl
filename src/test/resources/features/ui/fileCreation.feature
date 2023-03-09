Feature: File creation in a repository

  @Ui @DefectiveTest
  Scenario Outline: Create file in a repository
    Given login page is opened
    And user with login "<username>" and password "Aqa18OnlDipl#1" is logged in
    And user "<username>" opens repository "FirstRepository" page
    And file creation page is opened
    When new file is created
    Then new file is shown in the repository contents
    Examples:
      | username        |
      | DiplomaAqa18Onl |
