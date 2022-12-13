package Frameworkdesign.kirankatkar;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Kiran.PageoObject.LoadingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cartselectedprod = "ZARA COAT 3";
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
LoadingPage lp = new LoadingPage(driver);
lp.Goto();
lp.Login("kirankatkar3317@gmail.com", "Kiran@1994");

	}

}
