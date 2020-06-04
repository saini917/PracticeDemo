package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		// execute this code only when place id is null
		// write a code that will give you place id

		placeValidationTest id = new placeValidationTest();
		if (placeValidationTest.place_id == null) {
			id.add_Place_Payload_with("deepak", "French", "Asia");
			id.user_calls_with_http_request("AddPlaceAPI", "POST");
			id.verify_place_Id_created_maps_to_using("deepak", "getPlaceAPI");
		}

	}

}
