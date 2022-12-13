package mavenproj;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class NavpageTest extends base{
	
	@BeforeTest
	public void Teststart() throws IOException
	{
		driver = DriverIntialization();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void NavpageavailableTest() throws IOException {

LandingPage lp = new LandingPage(driver);
Assert.assertTrue(lp.Nav().isDisplayed());


}
	
	@AfterTest
	public void Testend()
	{
driver.close();
	}
}
