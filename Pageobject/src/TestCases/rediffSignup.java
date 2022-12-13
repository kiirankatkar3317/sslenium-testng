package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjectRepository.RediffSignuppage;

public class rediffSignup {
	//objectfactory

@SuppressWarnings("unused")
@Test
	public void Signup() {
	System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		RediffSignuppage rs = new RediffSignuppage(driver);
		rs.name().sendKeys("kiran");
		rs.pass1().sendKeys("kk");
		
		
	}
}
