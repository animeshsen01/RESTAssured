package practice.RestAPI;

import org.testng.Assert;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(PayLoad.coursePrice());
		
		//Print number of courses returned by API
		int courseCount = js.getInt("courses.size()");
		System.out.println("The no. of courses present in the json response is: " + courseCount);
		
		//Print the Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The purchase amount is: " + totalAmount);
		
		//Print the title of the first course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println("The title of the first course is: " + titleFirstCourse);
		
		//Print all course titles and their respective prices
		for (int i=0; i<courseCount; i++)
		{
			String title = js.get("courses["+i+"].title");
			Integer price = js.get("courses["+i+"].price");
			System.out.println("The title of course"+i+" is: " + title);
			System.out.println("The price of course"+i+" is: " + price);
		}
		
		//Print no. of copies sold by RPA course
		for (int i=0; i<courseCount; i++)
		{
			String titles = js.get("courses["+i+"].title");
			if(titles.equalsIgnoreCase("RPA"))
			{
				Integer copies = js.get("courses["+i+"].copies");
				System.out.println("The number of copies sold by RPA course is: " + copies);
				break;
			}
			
		}
		int sum =0;
		//Verify if sum of all course prices mathes with purchase amount
		for (int i=0; i<courseCount; i++)
		{
			Integer price = js.get("courses["+i+"].price");
			Integer copies = js.get("courses["+i+"].copies");
			sum=sum+(price*copies);
		}
		System.out.println("The sum amount is: " + sum);
		Assert.assertEquals(sum, totalAmount);
			

	}

}
