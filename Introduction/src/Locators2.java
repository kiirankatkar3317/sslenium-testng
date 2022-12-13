import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub);
String Name = "kirankatkar3317";
System.setProperty("webdriver.chrome.driver", "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
String Password = getPassword(driver);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
driver.get("https://rahulshettyacademy.com/locatorspractice/");
driver.findElement(By.id("inputUsername")).sendKeys(Name);
driver.findElement(By.name("inputPassword")).sendKeys(Password);
driver.findElement(By.className("signInBtn")).click();
Thread.sleep(1000);
System.out.println(driver.findElement(By.tagName("p")).getText());
Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
Assert.assertEquals(driver.findElement(By.cssSelector("div[class = 'login-container'] h2")).getText(),"Hello "+Name+",");
driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();

	}
public static String getPassword(WebDriver driver) throws InterruptedException{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.xpath("//div/form/p")).getText());
		String PasswordText = driver.findElement(By.xpath("//div/form/p")).getText();
		String[] PasswordArray = PasswordText.split("'");
		String[] passwordArray2 = PasswordArray[1].split("'");
		String Password = passwordArray2[0];
		System.out.println(Password);
		return Password;
	}
}
