package com.weather;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class WeatherCompare {
	
	@Test
	public void weatherReport1() {
		  
		          Response responseById=given().
		                   parameter("id","2172797").
		                   parameter("appid", "6f08990f1a8f589c4df7d551c4954161").
				           when().get("http://api.openweathermap.org/data/2.5/weather");
				  
				  
				  String weatherReportByID=responseById.
				         then().contentType(ContentType.JSON).
				         extract().path("weather[0].description");
				  System.out.println("Weather Description by ID :" +weatherReportByID);
				  
				  String lon=String.valueOf(responseById.
					         then().contentType(ContentType.JSON).
					         extract().path("coord.lon"));
				  System.out.println("longitude is: " +lon);
				  
				  String lat=String.valueOf(responseById.
					         then().contentType(ContentType.JSON).
					         extract().path("coord.lat"));
				  System.out.println("latitude is: " +lat);
				  
				  
				  Response responseByCoordinates=given().
		                   parameter("lat",lat).
		                   parameter("lon", lon).
		                   parameter("appid", "6f08990f1a8f589c4df7d551c4954161").
				           when().get("http://api.openweathermap.org/data/2.5/weather");
				  
				  String weatherReportByCoordinates=responseByCoordinates.
					         then().contentType(ContentType.JSON).
					         extract().path("weather[0].description");
					  System.out.println("Weather Description by coordinates :" +weatherReportByCoordinates);
					  
					  Assert.assertEquals(weatherReportByID, weatherReportByCoordinates);
					  
	}

}
