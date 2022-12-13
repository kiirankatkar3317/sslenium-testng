import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/locatorspractice/");
driver.findElement(By.linkText("Forgot your password?")).click();
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
System.out.println(driver.findElement(By.xpath("//div/form/p")).getText());
String PasswordText = driver.findElement(By.xpath("//div/form/p")).getText();
String[] PassWordarray = PasswordText.split("'");


	
	}

}
