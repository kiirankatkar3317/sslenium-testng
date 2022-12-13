import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver" , "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
driver.get("https://rahulshettyacademy.com/locatorspractice/");
driver.findElement(By.id("inputUsername")).sendKeys("8286979103");
driver.findElement(By.name("inputPassword")).sendKeys("8286979103");
driver.findElement(By.className("submit")).click();
System.out.println(driver.findElement(By.cssSelector(".error")).getText());
driver.findElement(By.linkText("Forgot your password?")).click();
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Kiran");
driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("kirankatkar3317@gmail.com");
driver.findElement(By.xpath("//input[@type= 'text'][2]")).clear();
driver.findElement(By.cssSelector("input[type= 'text']:nth-child(3)")).sendKeys("kirankatkar3318@gmail.com");
driver.findElement(By.xpath("//form/input[3]")).sendKeys("8286979103");
driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
System.out.println(driver.findElement(By.cssSelector("form p")).getText());
driver.findElement(By.className("go-to-login-btn")).click();
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.findElement(By.id("inputUsername")).sendKeys("8286979102");
driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
driver.findElement(By.cssSelector("#chkboxOne")).click();
driver.findElement(By.cssSelector("#chkboxTwo")).click();
driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


//driver.findElement(null)
//driver.findElement(By.cssSelector("._3AWRsL")).click();
//System.out.println(driver.findElement(By.cssSelector("span._2YULOR")).getText());
//driver.findElement(By.linkText("New to Flipkart? Create an account")).click();
//System.out.println(driver.findElement(By.xpath("//input['@xpath= 7']")).sendKeys("8286979103"));
	}
	



}




