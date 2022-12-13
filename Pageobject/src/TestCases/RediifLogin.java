package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjectRepository.RediffLoginpage;
import PageObjectRepository.RediffSignuppage;

public class RediifLogin {

	//objectpattern

	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		@SuppressWarnings("unused")
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		RediffLoginpage rl = new RediffLoginpage(driver);
		rl.Emailid().sendKeys("kirankatkar3317@gmail.com");
		rl.Pass().sendKeys("Kiran@9103");
		//rl.Submit().click();
		rl.newlink().click();
		RediffSignuppage rs = new RediffSignuppage(driver);
		rs.name().sendKeys("kk");
		rs.pass1().sendKeys("kk2");
	}
}
