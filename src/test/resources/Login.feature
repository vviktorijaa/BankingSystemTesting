Feature: Banking system login

  Scenario: Successful login
    Given I start the application
    When I type the password "admin"
    And I click on the login button
    Then login is successful