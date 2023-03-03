@TestFeature
Feature: Repositories testing

  Scenario: Authorized user create repo
    Given Authorized user
    When create repos send Post request and get response


  Scenario: Get information about created repo
    Given  Authorized user
    When User send GET request about repository


