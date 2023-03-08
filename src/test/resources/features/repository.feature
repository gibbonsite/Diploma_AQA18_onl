Feature: Code repository

  Background:
    Given login page is opened
    And user with login "DiplomaAqa18Onl" and password "Aqa18OnlDipl#1" is logged in

  @SmokeTest
  Scenario Outline: Repository creation
    Given repository creation page is opened
    When new repository "<repository>" is created
    Then repository "<repository>" page is opened
    Examples:
      | repository        |
      | AnotherRepository |

  @RegressionTest
  Scenario Outline: Repository deletion
    Given user "<username>" opens repository "<repository>" page
    And repository settings page is opened
    When repository "<repository>" of user "<username>" is deleted
    Then message about successful repository deletion is shown
    Examples:
      | username        | repository           |
      | DiplomaAqa18Onl | RepositoryDeletion01 |

  @RegressionTest
  Scenario Outline: Boundary test for repository creation
    Given repository creation page is opened
    When new repository "<repository>" is created
    Then repository "<repository>" page is opened
    Examples:
      | repository |
      | A          |
      | A3A5A7A9A12A15A18A21A24A27A30A33A36A39A42A45A48A51A54A57A60A63A66A69A72A75A78A81A84A87A90A93A96A100A |

  @SmokeTest
  Scenario Outline: Uploading file to repository
    Given user "<username>" opens repository "<repository>" page
    And file upload page is opened for repository "<repository>" of user "<username>"
    When file is uploaded to a repository
    Then repository "<repository>" page is opened
    Examples:
      | username        | repository      |
      | DiplomaAqa18Onl | FirstRepository |

  @RegressionTest
  Scenario: Create repository with extremely long description
    Given repository creation page is opened
    When repository with extremely long description is attempted to create
    Then input check message about extremely long repository description is shown
