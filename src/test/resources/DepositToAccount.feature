#Feature: Deposit to account
#
#  Scenario: Successful deposit to an existing account
#    Given The application is started
#    When I click on the Deposit To Account button
#    And input 39933 as Account Number
#    And input 10000 in Amount field
#    And click on the Deposit button
#    And click on the Yes button
#    Then the deposit is successful
#
#  Scenario: Unsuccessful deposit to a bank account that does not exist
#    Given The application is started
#    When I click on the Deposit To Account button
#    And input 11111 as Account Number
#    And input 5000 in Amount field
#    And click on the Deposit button
#    And click on the Yes button
#    Then the deposit is not successful
#
#  Scenario: Reset inputted information due to wrong amount
#    Given The application is started
#    When I click on the Deposit To Account button
#    And input 16759 as Account Number
#    And input 50 in Amount field
#    And click on the Reset button
#    Then the input fields must be empty
#
#  Scenario: Deposit from an account: empty input fields
#    Given The application is started
#    When I click on the Deposit To Account button
#    Then Exception must be thrown when I click on the Deposit button