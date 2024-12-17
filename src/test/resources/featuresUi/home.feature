Feature: Home Page

#  @web
#  Scenario: Slideable carousel
#    Given user is on home page
#    When user clicks "next" arrow on carousel
#    Then carousel slides

  @web
  Scenario: Display products by category
    Given user is on home page
    When user clicks "Phones" on categories
    Then page display only products under "Phones" category

  @web
  Scenario: Redirect to display products from all categories when click on the category header
    Given user is on home page
    When user clicks category header
    Then products from all categories are displayed

  @web
  Scenario:  Validate previous and next button on home page
    Given user is on home page
    When user clicks "Next" button
    Then page display "Next" set of products

    When user clicks "Previous" button
    Then page display "Previous" set of products

  @web
  Scenario: Validate specific product information
    Given user is on home page
    When user clicks on the "Samsung galaxy s6" title
    Then user redirect to "Samsung galaxy s6" description