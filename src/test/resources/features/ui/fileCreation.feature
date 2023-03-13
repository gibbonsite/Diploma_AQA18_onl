Feature: File creation in a repository

  @Ui @DefectiveTest
  Scenario: Create file in a repository
    Given login page is opened
    And user with his login and password is logged in
    And user opens repository "FirstRepository" page
    And file creation page is opened
    When new file is created
    Then new file is shown in the repository contents
