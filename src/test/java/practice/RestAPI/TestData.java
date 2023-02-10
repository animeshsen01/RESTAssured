package practice.RestAPI;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="BooksData")
	public Object[] getData()
	{
		Object[] aisle = new Object[2];
		aisle[0] = "anim132";
		aisle[1] = "anim133";
		return aisle;
		
	}

}
