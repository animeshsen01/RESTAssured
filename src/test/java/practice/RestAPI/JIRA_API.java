package practice.RestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JIRA_API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080";
		
		//Sign into JIRA
		String responseSignIn =
		given().log().all().header("Content-Type","application/json").body(PayLoad.signInJIRA())
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = new JsonPath (responseSignIn);
		String sessionName = js.get("session.name");
		String sessionValue = js.get("session.value");
		String sessionCookie = sessionName+"="+sessionValue;
		System.out.println("The session ID is: " + sessionCookie);
		
		//Create an issue
		String responseAddIssue =
				given().log().all().header("Content-Type","application/json").header("cookie", sessionCookie).body(PayLoad.createIssue())
				.when().post("/rest/api/2/issue")
				.then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
		
		JsonPath js1 = new JsonPath (responseAddIssue);
		String issueID = js1.get("id");
		System.out.println("The issue ID is: " + issueID);
		
		//Add Comment
		String commentGiven = "My first comment";
		String responseAddComment =
				given().log().all().header("Content-Type","application/json").header("cookie", sessionCookie).body(PayLoad.addComment(commentGiven))
				.when().post("rest/api/2/issue/"+issueID+"/comment")
				.then().log().all().assertThat().statusCode(201)
				.extract().response().asString();
		
		JsonPath js2 = new JsonPath (responseAddComment);
		String commentID = js2.get("id");
		System.out.println("The comment ID is: " + commentID);
		

	}

}
