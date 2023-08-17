Feature: Feature to test login functionality

	Background:
		Given user is on login page
		And clicks on the Log In link
	
  Scenario: Check login is successfull with valid email & password
    When user enters correct email and password on the login page
    And click on sign in button
    Then user should be able to navigate to the home page

    Scenario: Check login is not successful with valid email & invalid password
    When user enters correct email and incorrect password "<password>" on the login page
    And click the sign in button
    Then user should not be allowed to login
    
    Examples:
    | password   |
	  | 123        |
	  