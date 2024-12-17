Feature: Contact

  @web
  Scenario: Display New Message form
    Given user is on home page
    When user clicks New message menu
    Then New message form is displayed

  @web
  Scenario: Test Contact button Close
    Given user is on New message form
    When user clicks New message Close button
    Then New message form is closed

  @web
  Scenario: Test send message
    Given user is on New message form
    When user input contact email with "user12@test.com"
    And user input contact name with "user12"
    And user input message with "Hello! How do I change my password?"
    And user clicks Send message button
    Then pop-up appears with the message "Thanks for the message!!"