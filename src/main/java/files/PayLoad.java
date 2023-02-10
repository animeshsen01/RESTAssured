package files;

public class PayLoad {
	
	public static String addPlace()
	{
		return "{\n"
				+ "  \"location\": {\n"
				+ "    \"lat\": -38.383494,\n"
				+ "    \"lng\": 33.427362\n"
				+ "  },\n"
				+ "  \"accuracy\": 50,\n"
				+ "  \"name\": \"Frontline house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\n"
				+ "  \"types\": [\n"
				+ "    \"shoe park\",\n"
				+ "    \"shop\"\n"
				+ "  ],\n"
				+ "  \"website\": \"http://google.com\",\n"
				+ "  \"language\": \"French-IN\"\n"
				+ "}";
	}
	
	public static String coursePrice()
	{
		return "{\n"
				+ "\n"
				+ "\"dashboard\": {\n"
				+ "\n"
				+ "\"purchaseAmount\": 910,\n"
				+ "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "\"courses\": [\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\n"
				+ "\"price\": 50,\n"
				+ "\n"
				+ "\"copies\": 6\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"RPA\",\n"
				+ "\n"
				+ "\"price\": 45,\n"
				+ "\n"
				+ "\"copies\": 10\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "]\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "";
	}
	
	public static String addBook(String aisle)
	{
		String body = "{\n"
				+ "\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\n"
				+ "\"isbn\":\"bcd\",\n"
				+ "\"aisle\":\""+aisle+"\",\n"
				+ "\"author\":\"John foe\"\n"
				+ "}\n"
				+ "";
		return body;
	}
	
	public static String signInJIRA()
	{
		return "{ \"username\": \"animesh.sen01\", \"password\": \"MyJIRA01*\" }";
	}
	
	public static String createIssue()
	{
		return "{    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RSA\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"something's wrong\",\r\n"
				+ "        \"description\": \"Creating an issue using Project Keys\" ,\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
	}
	
	public static String addComment(String comment)
	{
		return "{\r\n"
				+ "    \"body\": \""+comment+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}

}
