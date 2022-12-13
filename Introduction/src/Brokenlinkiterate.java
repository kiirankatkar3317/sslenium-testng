import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinkiterate {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert a = new SoftAssert();
     List<WebElement> links =  driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
     
 for(WebElement link : links) {
	 String url = link.getAttribute("href");
	 HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
	 conn.setRequestMethod("HEAD");
	 conn.connect();
	 int code = conn.getResponseCode();
	 System.out.println(code);
	 a.assertTrue(code<400, "The below link is broken "+link.getText()+" with response code " +code);
	// if(code > 400) {
	//	 System.out.println("The below link is broken "+link.getText()+" with response code " +code);
	//	 Assert.assertTrue(false);
//	 }
	 
 }
 a.assertAll();
	}
}
