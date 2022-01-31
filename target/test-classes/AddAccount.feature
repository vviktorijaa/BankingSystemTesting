#Feature: Add account
#
#  Scenario: Reset information when adding savings account
#    Given The application is started
#    When I click on the Add Account button
#    And click on the Add Savings Account button
#    And input "My savings account" in the name field
#    And input 10000 in the balance field
#    And input 5000 in the maximum withdraw limit field
#    And click on the Reset button
#    Then the input fields must be empty
#
#  Scenario: Add savings account successfully
#    Given The application is started
#    When I click on the Add Account button
#    And click on the Add Savings Account button
#    And input "My savings account" in the name field
#    And input 10000 in the balance field
#    And input 5000 in the maximum withdraw limit field
#    And click on the Add button
#    And click on the yes button in the confirm dialog box
#    Then the account is added successfully
#
#  Scenario: Add savings account unsuccessfully
#    Given The application is started
#    When I click on the Add Account button
#    And click on the Add Savings Account button
#    And input "My savings account" in the name field
#    And input 10000 in the balance field
#    And input 5000 in the maximum withdraw limit field
#    And click on the Add button
#    And click on the no button in the confirm dialog box
#    Then the account is not added
#
#  Scenario: Add savings account: empty input fields
#    Given The application is started
#    When I click on the Add Account button
#    And click on the Add Savings Account button
#    Then Exception must be thrown when I click on the Add button