Feature: Exit the application

  Scenario: Exit the application
    Given The application is started
    When user clicks on the Exit button
    Then the application closes
#  Then a popup window with "Thanks for using" text appears