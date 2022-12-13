package mavenproj;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class PagetitleValidation extends base{

	@BeforeTest
	public void Teststart() throws IOException
	{
		driver = DriverIntialization();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void TitleTest() throws IOException{
driver = DriverIntialization();
driver.get(prop.getProperty("url"));
LandingPage lp= new LandingPage(driver);
System.out.println(lp.Title().getText());
Assert.assertEquals(lp.Title().getText(), "FEATURED COURSES");
}
	@AfterTest
	public void Testend()
	{
driver.close();
	}
}