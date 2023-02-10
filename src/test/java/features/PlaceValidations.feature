

Feature: Place API Validation
  I want to use this template for my feature file

  @addPlace
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given The payload has been added for AddPlaceAPI with "<name>" "<language>" "<address>"
    When The user calls "addPlaceAPI" with "POST" http request
    Then The API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    
Examples:
		|name  |language|address    |
		|AHouse|French  |City Centre|
#		|BHouse|Hindi  |City Centre|

	@deletePlace
  Scenario: Verify if Place is being successfully deleted using DeletePlaceAPI
    Given The payload has been added for deletePlaceAPI
    When The user calls "deletePlaceAPI" with "POST" http request
    Then The API call is successful with status code 200
    #And "status" in response body is "OK"
    

		

