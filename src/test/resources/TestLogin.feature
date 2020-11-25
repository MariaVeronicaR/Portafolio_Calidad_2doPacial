Feature: Test user logig

	Scenario Outline: User login successfully with credentials
	Given Browser is open
	And user is in login page
	When user enters <username> and <password> 
	And user clicks login button
	Then website shows main page
	
	Examples:
	|username||password|
	|veronica||12345|
	|Grace||12345|