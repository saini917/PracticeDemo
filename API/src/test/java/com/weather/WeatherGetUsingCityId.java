package com.weather;

import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;;

public class WeatherGetUsingCityId {
	
	//@Test
	public void weatherReport() {
		  
		          String weatherReport=given().
		          parameter("id","2172797").
		          parameter("appid", "6f08990f1a8f589c4df7d551c4954161").
				  when().get("http://api.openweathermap.org/data/2.5/weather").
				  then().contentType(ContentType.JSON).
				  extract().path("weather[0].description");
		          
		          System.out.println("Weather Report: "+weatherReport);
	}
	
	
	
	
	//real time work
	@Test
	public void weatherReport1() {
		  
		          Response response=given().
		                   parameter("id","2172797").
		                   parameter("appid", "6f08990f1a8f589c4df7d551c4954161").
				          when().get("http://api.openweathermap.org/data/2.5/weather");
				  
				  
				  String actualWeatherReport=response.
				         then().contentType(ContentType.JSON).
				         extract().path("weather[0].description");
				  
				  String expectedWeatherReport=null;
				  
				  if(actualWeatherReport.equalsIgnoreCase(expectedWeatherReport)){
					  System.out.println("Testcase pass");
				  }
				  else{
					  System.out.println("Testcase fail");
				  }
		          
		          
	}

}
