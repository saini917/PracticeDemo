package POJOClasses;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class MainDeserialization {
	
	static String[] courseTitles={"Selenium Webdriver java","Cypress","Protractor"};

	// rest assured -- treated special character as numeric value, so stop this
	// one we can use urlEncodingEnabled(false) to stop encoding
	public static WebDriver driver;
	public static WebDriverManager manager;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		manager.chromedriver().version("2.40").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(
				"https://accounts.google.com/signin/oauth/identifier?client_id=990572338172-iibth2em4l86htv30eg1v44jia37fuo5.apps.googleusercontent.com&as=GfRBrkhGeyvswZmO0VZusA&destination=https%3A%2F%2Fin.bookmyshow.com&approval_state=!ChQ4ZEtacVhiNGlxUWYwV0phV21ZUBIfYzdINzFBWklPSWNlOEhuU1JuY2dubXFPOWV5LUV4Yw%E2%88%99AF-3PDcAAAAAXodx9j25bChlrBKfe4-jnc1p3WjJWCie&oauthgdpr=1&xsrfsig=ChkAeAh8T5zD_PQkpyosnTbfHl2cGnXXC9bmEg5hcHByb3ZhbF9zdGF0ZRILZGVzdGluYXRpb24SBXNvYWN1Eg9vYXV0aHJpc2t5c2NvcGU&flowName=GeneralOAuthFlow");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("saini1987deepak@gmail.com");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Reema@1994");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];

		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UwNRj340YYaK_W")
				.queryParam("redirect_url", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");

		// deserialization code
		GetCourse gc = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		List<Api> apiCourses = gc.getCourses().getApi();
		for (int i = 0; i < apiCourses.size(); i++) {
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoupUI Webservices Testing")) {
				System.out.println(apiCourses.get(i).getPrice());
			}
		}

		//get the courses name of webautomation
		ArrayList<String> a=new ArrayList<String>();
		List<WebAutomation> webAutomation=gc.getCourses().getWebAutomation();
		for(int i=0;i<webAutomation.size();i++){
			System.out.println(webAutomation.get(i).getCourseTitle());
			a.add(webAutomation.get(i).getCourseTitle());
		}
		
		List<String> expectedList= Arrays.asList(courseTitles);
		Assert.assertTrue(a.equals(expectedList));	

	}

}
