Feature: About us

  @web
  Scenario: Display about us content
    Given user is on home page
    When user clicks About us
    Then About us content is displayed

  @web
  Scenario: Test About us button Close
    Given user is on About us content
    When user clicks About us Close button
    Then About us content is closed