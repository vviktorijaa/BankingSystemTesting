#Feature: Add account
#
#  Scenario: Add savings account successfully
#    Given The application is started
#    When I click on the Add Account button
#    And click on the Add Savings Account button
#    Then input "My savings account" in the name field
#    And input 10000 in the balance field
#    When input 5000 in the maximum withdraw limit field
#    And click on the Add button
#    Then click on the yes button in the confirm dialog box
#    And the account is added successfully