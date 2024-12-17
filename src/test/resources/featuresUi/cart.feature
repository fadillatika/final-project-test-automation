Feature: Cart

  @web
  Scenario: Validate cart feature work
    Given user is on home page
    When user clicks Cart on Navbar
    Then user redirect to cart page

  @web
  Scenario: Redirect to home page when click on the logo brand
    Given user is on cart page
    When user clicks on the brand logo
    Then user redirect to home page

  @web
  Scenario: Adding product to the cart
    Given user is on "Samsung galaxy s6" description product
    When user clicks add to cart button
    Then pop-up "Product added" appears

  @web
  Scenario: Validate product on cart is appropriate
    Given user has added
      | Samsung galaxy s6 |
      | Nokia lumia 1520 |
    When user clicks Cart on Navbar
    And user redirect to cart page
    Then ensure the product appears in the cart
      | Samsung galaxy s6 |
      | Nokia lumia 1520 |
    Then ensure that the product price displayed in the cart matches
      | Samsung galaxy s6 | 360 |
      | Nokia lumia 1520  | 820 |
    Then ensure that the number of products in the cart is as added
      | Samsung galaxy s6 |
      | Nokia lumia 1520 |

  @web
  Scenario: Validate total price in cart page
    Given user has added
      | Samsung galaxy s6 |
      | Nokia lumia 1520 |
    When user accesses cart page
    Then total price is correct
      | Samsung galaxy s6 | 360 |
      | Nokia lumia 1520 | 820 |

  @web
  Scenario: Delete product from cart
    Given user has added
      | Samsung galaxy s6 |
    When user accesses cart page
    And user clicks delete button on "Samsung galaxy s6"
    Then product "Samsung galaxy s6" deleted

  @web
  Scenario: Place Order feature accessible
    Given user has added
      | Samsung galaxy s6 |
    When user accesses cart page
    And user clicks place order button
    Then form of data to fill in appears

  @web
  Scenario: Validate total price in data form is correct
    Given user success placing orders
      | Samsung galaxy s6 |
      | Nokia lumia 1520 |
    Then form of data to fill in appears
    Then total price in form is correct

  @web
  Scenario: Place order with filled in all data form
    Given form data to fill in appears
    When user input name with "haha"
    And user input country with "hihi"
    And user input city with "hoho"
    And user input credit card with "123"
    And user input month with "1"
    And user input year with "90"
    Then user clicks purchase button
    Then user successfully purchases product

  @web
  Scenario: Place order without filling in name and credit card
    Given form data to fill in appears
    And user input country with ""
    And user input city with ""
    And user input month with ""
    And user input year with ""
    Then user clicks purchase button
    Then pop-up "Please fill out Name and Creditcard." on cart appears
