package practice.RestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add Place
		String response =
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(PayLoad.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)")
		.extract().response().asString();
		
		JsonPath js = new JsonPath (response);
		String placeId = js.getString("place_id");
		
		System.out.println("The place id is: " + placeId);
		
		
		String givenAddress = "70 winter walk, USA";
		//Update Place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\n"
				+ "\"place_id\":\""+placeId+"\",\n"
				+ "\"address\":\""+givenAddress+"\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String retrievedAddress = js1.getString("address");
		System.out.println("The updated address is: " + retrievedAddress);
		
		Assert.assertEquals(retrievedAddress, givenAddress);
		

	}

}
