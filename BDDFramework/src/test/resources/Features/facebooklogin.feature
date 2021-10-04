Feature: Automate Facebook Login Page

  Scenario: Login to Facebook Page
  
    Given User is on Facebook Login Page
    When user enters username and password
    And clicks on login page
    Then verify that user is navigated to home page