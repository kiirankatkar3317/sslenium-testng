package exceldriver.framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderclass {
	@Test(dataProvider = "get")
	public void initializedata(String firstname, String middlename, String lastname) {
		
		
		System.out.println(firstname);
		
	}
	
	
	
	
	@DataProvider(name = "get")
	public Object[][] getData() {
	 Object[][] data= {{"kiran","anant","katkar"},{"Anant","vitthal","katkar"}};
	return data;
	}

}
