package mavenproj;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	
	@BeforeTest
	public void Testbegin() throws IOException
	{
		driver = DriverIntialization();
		driver.get("http://qaclickacademy.com");	
	}
	
	
	@Test(dataProvider = "getData")
	public void HomepageContent(String usern, String pass, String user) throws IOException {

		LandingPage l = new LandingPage(driver);
		l.login().click();
		LoginPage lp = new LoginPage(driver);
		lp.Username().sendKeys(usern);
		lp.Password().sendKeys(pass);
		System.out.println(user);
		lp.Button().click();
	}

	@AfterTest
	public void Testend()
	{
driver.close();
	}
	
	
	@DataProvider

	public Object[][] getData() {
		Object[][] obj = new Object[2][3];
		obj[0][0] = "kdkddk@kk.com";
		obj[0][1] = "kdddkld";
		obj[0][2] = "restricted";

		obj[1][0] = "jkdxmw@lo.com";
		obj[1][1] = "dmkcdmc";
		obj[1][2] = "unrestricted";

		return obj;
	}

}
