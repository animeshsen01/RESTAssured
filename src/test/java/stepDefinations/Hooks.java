package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@deletePlace")
	public void beforeScenario() throws Throwable
	{
		if(PlaceValidationsSteps.placeId==null)
		{
			PlaceValidationsSteps steps = new PlaceValidationsSteps();
			steps.the_payload_has_been_added_for_add_place_api_with("Animesh", "Benagli", "Birhata");
			steps.the_user_calls_with_http_request("addPlaceAPI", "POST");
			steps.verify_place_id_created_maps_to_using("Animesh", "getPlaceAPI");
		}	
	}

}
