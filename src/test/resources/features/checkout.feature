@Checkout
Feature: Purchase
  As a user i want buy of one product

  Scenario: Login, Adding 2 item to cart, Remove 1 from cart and then finish the checkout
    Given User open the web sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page
    When User sort product by "Price (low to high)"
    And User click add to cart item "Sauce Labs Onesie"
    And User click add to cart item "Sauce Labs Bike Light"
    And User click shopping cart badge
    And User remove Sauce Labs Bike Light from shopping cart
    And User click icon Checkout button
    Then User redirected to checkout step on the page
    When User input "Marco" as firstname "Rossi" as lastname "23123" as zipcode
    And User click continue button again
    Then User will redirected to checkout overview next page
    And User can see summary total
    When User click again finish button
    Then User redirected to Checkout complete page