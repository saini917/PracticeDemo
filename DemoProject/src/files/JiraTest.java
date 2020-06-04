package files;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

// This is Cookie based Authenication by using Jira Rest API


//https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/
//https://developer.atlassian.com/cloud/jira/platform/rest/v3/?utm_source=%2Fcloud%2Fjira%2Fplatform%2Frest%2F&utm_medium=302#api-rest-api-3-issue-issueIdOrKey-comment-get

//NOTES:
// You can use jsonpath or sessionfilter to store the response
// if the site is https --> Rest Assured some times is not working so that their is one method added after given() method relaxedHTTPSValidation() will take care 

/*
 *  INTERVIEW QUESTIONS:
 * 1) How to Create Session Filter for Authenication in Rest Assured Automation
 * 2) In introducing Path Parameters and Query Parameters together Single Test
 * 3) Sending Files as Attachements using Rest Assured with Multipart method
 * 4) Parsing complex Json and limiting Json response through Query Parameters
 * 5) Handling HTTPS Certification validation through Automated Code
 */
public class JiraTest {
	static JsonPath js;

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://jira.example.com:8080";
		SessionFilter session=new SessionFilter();
		
		//login scenario
		 given().relaxedHTTPSValidation().header("Content-Type","application/json")
		.body("{ \r\n" + 
				"	\"username\": \"deepaksaini\",\r\n" + 
				"    \"password\": \"Reema@1994\" \r\n" + 
				"	\r\n" + 
				"}").log().all().filter(session)
		.when().post("/rest/auth/1/session")
		.then().log().all().extract().response().asString();
		
		
		
		//Add comment in jira
		//POST -->/rest/api/3/issue/{issueIdOrKey}/comment
		//{issueIdOrKey} --> path parameter
		 
		String expectedMessage="hi i am logged the bug";
		String addCommentResponse=given().pathParam("key", "10923").log().all().header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"visibility\": {\r\n" + 
				"    \"type\": \"role\",\r\n" + 
				"    \"value\": \"Administrators\"\r\n" + 
				"  },\r\n" + 
				"  \"body\": \""+expectedMessage+"\"\r\n" + 
				"}'").filter(session)
		.when().post("/rest/api/3/issue/{key}/comment")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
	    js=new JsonPath(addCommentResponse);
		String commentId=js.getString("id");


	
	//Add attachment
	//POST --> /rest/api/2/issue/{issueIdOrKey}/attachments
	//multipart is a method is used to upload the file attachment
		
		given().header("X-Atlassian-Token","no-check").filter(session).header("Content-Type"," multipart/form-data")
		.multiPart("file",new File("D:\\Workspace_NRDA\\DemoProject\\src\\tests\\jira.txt")).pathParam("key", "10923")
		.when().post("/rest/api/2/issue/{key}/attachments")
		.then().assertThat().statusCode(200);
		
		
		
		//Get issue
		//GET --> /rest/api/2/issue/{issueIdOrKey}
		//pathParam --> is used gothrough the resources to sub-resources
		//queryparam --> is used to filter out the resoucres
		
		String issueDetails=given().filter(session).pathParam("key", "10923")
		.queryParam("fields", "comment	").log().all()
		.when().get("/rest/api/2/issue/{key}")
		.then().log().all().extract().response().asString();
		System.out.println(issueDetails);
		
		// parsing complex json
		js=new JsonPath(issueDetails);
		int commentCount=js.getInt("fields.comment.comments.size()");
		for(int i=0;i<commentCount;i++){
			//System.out.println(js.getInt("fields.comment.comments["+i+"].id"));
			String commentIdIssue=js.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdIssue.equalsIgnoreCase(commentId)){
				String actualMessage=js.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(actualMessage);
				assertEquals(actualMessage, expectedMessage);
			}
		}
		
	}

}
