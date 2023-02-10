package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceValidationsSteps extends Utils {
	
	ResponseSpecification res;
	RequestSpecification resGiven;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String placeId;
	
	
	@Given("The payload has been added for AddPlaceAPI with {string} {string} {string}")
	public void the_payload_has_been_added_for_add_place_api_with(String name, String language, String address) throws IOException {
			resGiven =given().spec(requestSpecification()).body(data.addPlacePayLoadPOJO(name, language, address));

	    }

	@When("The user calls {string} with {string} http request")
	public void the_user_calls_with_http_request(String resource, String httpMethod) {
			APIResources resourceAPI = APIResources.valueOf(resource);
	    	res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();    	
	    	if(httpMethod.equalsIgnoreCase("POST"))
	    	{
	    	response = resGiven 	
	    		    .when().post(resourceAPI.getResource())
	    		    .then().spec(res)
	    		    .extract().response();
	    	}
	    	else if(httpMethod.equalsIgnoreCase("GET"))
	    	{
	    		response = resGiven 	
		    		    .when().get(resourceAPI.getResource())
		    		    .then().spec(res)
		    		    .extract().response();
	    	}
	    }

	    @Then("^The API call is successful with status code 200$")
	    public void the_api_call_is_successful_with_status_code_200() throws Throwable {
	    	Assert.assertEquals(response.getStatusCode(), 200);
	    	

	    }

	    
	    @And("{string} in response body is {string}")
	    public void in_response_body_is(String key, String expectedValue) {
	    	String actualValue = getJsonPath(response, key);
	    	Assert.assertEquals(actualValue, expectedValue);

	    }
	    
	    @Then("verify place_Id created maps to {string} using {string}")
	    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws Throwable {
	    	placeId = getJsonPath(response, "place_id");
	    	resGiven =given().spec(requestSpecification()).queryParam("place_id", placeId);
	    	the_user_calls_with_http_request(resource, "GET");
	    	String actualName = getJsonPath(response, "name");
	    	Assert.assertEquals(actualName, expectedName);
	    }
	    
	    @Given("The payload has been added for deletePlaceAPI")
	    public void the_payload_has_been_added_for_delete_place_api() throws IOException {
	    	resGiven =given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
	    }


}
