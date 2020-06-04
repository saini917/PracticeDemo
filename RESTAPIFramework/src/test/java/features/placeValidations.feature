Feature: Validating Place API's 

@AddPlace
Scenario Outline: Verify if Palce is being Sucessfully added using AddPlaceAPI 
	Given Add Place Payload with "<name>" "<language>" "<Address>" 
	When user calls "AddPlaceAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify place_Id created maps to "<name>" using "getPlaceAPI" 
	
	Examples: 
		|name   | language | address           |
		|AAhouse| English  | World cross center| 
		|BBhouse| Hindi    | sea   cross center|
		
		

@DeletePlace		
Scenario: Verify if Delete Place functionality is working 
	Given DeletePlace Payload 
	When user calls "DeletePlaceAPI" with "POST" http request 
	Then the API call got success with status code 200 
	And "status" in response body is "OK"