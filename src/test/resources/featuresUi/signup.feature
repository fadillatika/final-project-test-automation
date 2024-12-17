Feature: Sign Up

  @web
  Scenario: Display Sign Up form
    Given user is on home page
    When user clicks Sign Up menu
    Then Sign Up form is displayed

  @web
  Scenario: Test Sign Up button Closed
    Given user is on Sign Up form
    When user clicks Close button
    Then Sign Up form is closed

  @web
  Scenario: Register for a new account
    Given user is on Sign Up form
    When user input username
    And user input password
    And user clicks Sign Up button
    Then pop-up appears with the message "Sign up successful."

  @web
  Scenario: Test user can't register with the same username
    Given user is on Sign Up form
    When user input username with "draco_mAlfoy"
    And user input password with "passuser12"
    And user clicks Sign Up button
    Then pop-up appears with the message "This user already exist."