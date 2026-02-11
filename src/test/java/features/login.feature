Feature: Login demo site.

Scenario Outline: To verify Login with different User and password.
Given user is on login site
When User enter <username> and <password> and click on login button
Then login successfull "https://www.saucedemo.com/inventory.html"
Examples: 
  | username 				| password 		  | 
  | standard_user    		| secret_sauce    | 
  | locked_out_user 		| secret_sauce    | 
  | problem_user			| secret_sauce    | 
  | performance_glitch_user | secret_sauce    | 
  | error_user 				| secret_sauce    | 
  | visual_user    			| secret_sauce    | 