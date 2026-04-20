Feature: User login

  Scenario: Successful login
    Given user is on the login page
    When user enters valid credentials (user name:"ramsuu@gmail.com" and password:"rams123")
    And user clicks the login button
    Then user should be redirected to the my account page
    And user should see a welcome message