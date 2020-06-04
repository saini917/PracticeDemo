import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReusableMethods;
import files.payload;

public class basics {
	static JsonPath js;

	public static void main(String[] args) {
		// validate if Add Place API is working as expected
		// Add Place --> Update Place with new address --> Get Place to validate if address is present in response

		// given - all input details
		// when - submit the API -- resource and http method
		// then - validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();

		System.out.println(response);

		 // for pasring json
		js=ReusableMethods.rawToJson(response);
		String placeID = js.getString("place_id"); 
		System.out.println(placeID);
		
		//update place
		String newAddress="Summer Walk, Africa";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		String getPlaceresponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",placeID )
		.when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		 js=ReusableMethods.rawToJson(getPlaceresponse);
		String actualAddress= js.getString("address"); 
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
	}

}
