package files;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	@Test
	public void addBook() throws IOException{
		
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(GenerateStringFromResource("D:\\Workspace_NRDA\\DemoProject\\src\\tests\\AddBookDetails.json"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js=ReusableMethods.rawToJson(response);
		String message=js.get("Msg");
		System.out.println(message);
		String id=js.get("ID");
		System.out.println(id);
	}
	
	public static String GenerateStringFromResource(String path) throws IOException{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
