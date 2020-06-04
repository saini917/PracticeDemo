package com.weather;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	// simple get request for getting weather request by City name

	
	 // @Test(priority=1) 
	public void test_01() {
	  
	  Response response = when().
			  get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=6f08990f1a8f589c4df7d551c4954161"); 
	  System.out.println(response.statusCode());
	  assertEquals(response.statusCode(), 200); }
	  
	  //@Test(priority=2) 
	public void test_02() {
	  
	  Response response = when().get(
	  "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=6f08990f1a8f589c4df7d551c495416"
	  ); System.out.println(response.statusCode());
	  assertEquals(response.statusCode(), 401); }
	 

	// How to use parameter with rest assured
	
	  //@Test(priority = 3) 
	  public void test_03() {
	  
	  Response response = given().param("q", "London").param("APPID",
	  "6f08990f1a8f589c4df7d551c4954161")
	  .when().get("http://api.openweathermap.org/data/2.5/weather");
	  System.out.println(response.statusCode());
	  assertEquals(response.statusCode(), 200);
	  
	  if(response.statusCode()== 200){ System.out.println("API is working fine"
	  ); } else{ System.out.println("API is not working fine"); } }
	 

	// Assert our testcase in Rest Assured API
	@Test(priority = 4)
	public void test_04() {

		given().param("q", "London").param("APPID", "6f08990f1a8f589c4df7d551c4954161").
		when().get("http://api.openweathermap.org/data/2.5/weather").
		then().assertThat().statusCode(200);

	}
}
