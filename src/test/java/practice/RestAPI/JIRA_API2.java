package practice.RestAPI;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JIRA_API2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:8080";
		
		//Sign into JIRA or Creating a Session
		
		SessionFilter session = new SessionFilter();
		

		 given().log().all().header("Content-Type","application/json").body(PayLoad.signInJIRA())
		.filter(session)
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200);


		
		//Create an issue
		String responseAddIssue =
				given().log().all().header("Content-Type","application/json").body(PayLoad.createIssue())
				.filter(session)
				.when().post("/rest/api/2/issue")
				.then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
		
		JsonPath js1 = new JsonPath (responseAddIssue);
		String issueID = js1.get("id");
		System.out.println("The issue ID is: " + issueID);
		
		//Add Comment
		String commentGiven = "My first comment";
		String responseAddComment =
				given().log().all().pathParam("key", issueID).header("Content-Type","application/json").body(PayLoad.addComment(commentGiven))
				.filter(session)
				.when().post("rest/api/2/issue/{key}/comment")
				.then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
		
		JsonPath js2 = new JsonPath (responseAddComment);
		String commentID = js2.get("id");
		System.out.println("The comment ID is: " + commentID);
		
		//Add Attachment
//		given().log().all().pathParam("key", issueID).header("Content-Type","multipart/form-data").header("X-Atlassian-Token", "no-check")
//		.filter(session)
//		.multiPart("file", new File("D:\\EclipseWorkspace\\RESTAssured\\src\\test\\resources\\resources\\JiraAttachment.txt"))
//		.when().post("/rest/issue/{key}/attachments")
//		.then().log().all().assertThat().statusCode(200);
		
		//Get Issue Details
//		String issueDetails = given().log().all().pathParam("key", issueID).queryParam("fields", "comment")
//		.filter(session)
//		.when().get("/rest/issue/{key}")
//		.then().log().all().assertThat().statusCode(200)
//		.extract().response().asString();
//		System.out.println("The issue details of issue ID "+issueID+" is: "+issueDetails);
		
		//Validating Comment
//		JsonPath js3 = new JsonPath(issueDetails);
//		int commentSize = js3.get("fields.comment.size()");
//		for (int i=0; i<commentSize; i++)
//		{
//			String commentIDActual =js3.get("fields.comment["+i+"].id");
//			if(commentIDActual.equalsIgnoreCase(commentID))
//			{
//				String commentExtracted = js3.get("fields.comment["+i+"].body");
//				System.out.println("The comment for the comment ID "+commentID+" is: "+commentExtracted);
//				Assert.assertEquals(commentExtracted, commentGiven);
//				break;
//			}
//		}
		
		

	}

}
