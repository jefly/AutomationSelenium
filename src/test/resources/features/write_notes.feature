Feature: Feature to test writing a note functionality

	Background: 
		Given the user is on home page
		
  Scenario: Write a new note
    When user clicks on New
    And click on Note
    And writes a todo list
    And clicks on the profile on top left
    And click sign out
    Then user should be logged out

  Scenario: Open the previously written note 
    When clicks on the notes section
    And clicks on the note we wrote
    Then verify the note