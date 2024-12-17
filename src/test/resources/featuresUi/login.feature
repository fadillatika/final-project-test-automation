Feature: Log In

  @web
  Scenario: Display Log in form
    Given user is on home page
    When user clicks Log in menu
    Then Log in form is displayed

  @web
  Scenario: Test Login button Close
    Given user is on Log in form
    When user clicks Log in Close button
    Then Log in form is closed

  @web
  Scenario: Login with username and password
    Given user is on Log in form
    When user login with username "draco_mAlfoy"
    And user login with password "passuser123"
    And user clicks Log in button
    Then user is on homepage

  @web
  Scenario: Login with username and wrong password
    Given user is on Log in form
    When user login with username "draco_mAlfoy"
    And user login with password "passuser12"
    And user clicks Log in button
    Then pop-up appears with the message "Wrong password."

