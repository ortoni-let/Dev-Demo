Feature: Login into Service Now

@smoke
Scenario Outline: Login with multi 

	When user enter the username as "<UserName>" 
	And user enter the password as "<Password>" 
	And user clicks the login button 
	Then user must see the dashboard page 
	
	Examples: 
		|UserName|Password|
		|admin|peBeTLlVgT17|
		|admin|somepass|
@reg		
Scenario: Login Positive 
	When user enter the username as "admin" 
	And user enter the password as "JKaHY8lub4pL" 
	And user clicks the login button 
	Then user must see the dashboard page
	
@sanity	
Scenario: Login Negative 
	When user enter the username as "koushik" 
	And user enter the password as "somepass" 
	And user clicks the login button 
	But login should fail 
	