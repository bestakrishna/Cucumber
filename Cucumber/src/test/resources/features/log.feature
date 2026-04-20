Feature: Testing multiple scenarios

  @sanity
  Scenario: Testing data driven from excel
    Given user is on login page
    When user enters username and password from excel
    And clicks login button
    Then user should be logged in successfully

  @smoke
  Scenario: Entering form details
    Given i am on the home page
    When I enter the details name:"Krishna", Email:"kittu@gmail.com", Phone:"9959104689", Address:"Gadwal"
    And I click on gender button select "Male" button
    And I click the check box
    And click the dropDown boxes
    Then details are entered into the form

  @regression
  Scenario: Flight booking lowest price
    Given user is on booking webpage
    When user select departure city and destination city, click find flights
    And choose less price flight and click on choose this flight
    And Enter user details and click on purchace flight
    Then verify the thank you message