#Feature: Withdraw amount
#
#  Scenario: Successful withdraw from an existing bank account
#    Given The application is started
#    When I click on the Withdraw From Account button
#    And input 31556 as Account Number
#    And input 500 in Amount field
#    And click on the Withdraw button
#    Then the withdraw is successful
#
#  Scenario: Unsuccessful withdraw from an existing bank account: amount > balance
#    Given The application is started
#    When I click on the Withdraw From Account button
#    And input 16759 as Account Number
#    And input 5000 in Amount field
#    And click on the Withdraw button
#    Then the withdraw is unsuccessful
#
#  Scenario: Reset the inputted information in withdraw
#    Given The application is started
#    When I click on the Withdraw From Account button
#    And input 16759 as Account Number
#    And input 5000 in Amount field
#    And click on the Reset button
#    Then the input fields must be empty
#
#  Scenario: Withdraw from an account: empty input fields
#    Given The application is started
#    When I click on the Withdraw From Account button
#    Then Exception must be thrown when I click on the Withdraw button