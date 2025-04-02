@Login1
Feature:Login feature
  I want to Login the orenge hrm

   Background:
   Given I am in the orenge hrm login page
   
  @ValidCredentials1
  @ChromeBrowser
  Scenario: Valid Username and Password
    When The user provides a valid user id
    And user provides a valid password
    And user clicks the login button
    Then the user can see the dashboard
  
  @InvalidCredentials2
  @EdgeBrowser
  Scenario: Invalid username and password
  
   When The user provides a invalid user id
    And user provides a invalid password
    And user clicks the login button
    Then the user see the Invalid credentials
    
    
   
    
