package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoadPOJO(String name, String language, String address)
	{
		//Setting up the POJO Class using Setters
		AddPlace a = new AddPlace();
		a.setAccuracy(50);
		a.setName(name);
		a.setPhone_number("(+91) 98340313698");
		a.setAddress(address);
		a.setWebsite("https://www.google.com");
		a.setLanguage(language);
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
		
		return a;
	}
	
	public String deletePlacePayload(String placeId)
	{
		String deletePaylod = "{\r\n"
				+ "    \"place_id\":\""+placeId+"\"   	 	//(This value comes from Add place response)\r\n"
				+ "}";
		return deletePaylod;
	}

}
