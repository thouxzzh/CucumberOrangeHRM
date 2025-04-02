@Login2
@ChromeBrowser
Feature:Login feature
  I want to Login the orenge hrm
    

  Scenario Outline: Login with invalid credentials
    Given I want to enter username as <username>
    Given I want to enter password as <password>
    Then I verify the <status> in step

    Examples: 
      | username  | password      |    status  |
      | Admin     | admin123      |    success |
      | Thoushi   |  admin123     |    Fail    |