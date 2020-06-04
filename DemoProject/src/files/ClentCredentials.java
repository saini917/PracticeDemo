package files;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class ClentCredentials {

	public static void main(String[] args) {

		String accessTokenResponse = given().urlEncodingEnabled(false)
	 			.queryParam("code", "code")
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UwNRj340YYaK_W")
				.queryParam("redirect_url", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code")
				.when().log().all()
				.post("https://www.googleapis.com/oauth/v4/token").asString();
	 	JsonPath js =new JsonPath(accessTokenResponse);
	 	String accessToken=js.getString("access_token");

		String response = given().queryParam("access_token", accessToken)
				.when().log().all()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(response);

	}

}
