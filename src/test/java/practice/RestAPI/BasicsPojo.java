package practice.RestAPI;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

public class BasicsPojo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setting the values using POJO Class
		AddPlace a = new AddPlace();
		a.setAccuracy(50);
		a.setName("Animesh House");
		a.setPhone_number("(+91) 98340313698");
		a.setAddress("Murat Mahal Lane");
		a.setWebsite("https://www.google.com");
		a.setLanguage("Bengali");
		
		//Using Array List as setTypes method expect List
		List<String>typeList = new ArrayList<String>();
		typeList.add("Shoe Park");
		typeList.add("Shop");
		a.setTypes(typeList);
		
		//Creating object of Location POJO Class as setLocation method expect object of Location class
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		
		//Using RequestSpecBuilder and ResponseSpecBuilder for code re-usability
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		RequestSpecification resGiven =given().spec(req).body(a);
		
		String response = resGiven 	
	    .when().post("/maps/api/place/add/json")
	    .then().spec(res)
	    .extract().response().asString();
		
		System.out.println(response);
		
		
		
		

	}

}
