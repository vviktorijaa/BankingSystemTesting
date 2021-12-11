Feature: Add account

    Scenario: Add savings account successfully
    Given The application is started
    When I click on the Add Account button
    And click on the Add Savings Account button
    And input "My savings account" in the name field
    And input 10000 in the balance field
    And input 5000 in the maximum withdraw limit field
    And click on the Add button
    And click on the yes button in the confirm dialog box
    Then the account is added successfully