package practice.RestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import files.PayLoad;


public class DynamicJson {
	

	@Test(dataProvider = "BooksData", dataProviderClass = TestData.class)
	public void addBookValidation(String aisle)
	//public static void main(String[] args)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json").body(PayLoad.addBook(aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		//JsonPath js =ReusableMethods.stringToJson(response);
		JsonPath js =new JsonPath(response);
		String id = js.get("ID");
		System.out.println(id);
	}

}
