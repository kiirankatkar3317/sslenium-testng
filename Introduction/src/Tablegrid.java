import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tablegrid {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> values = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"] //tr/td[4]"));

		int sum = 0;

		for (int i = 0; i < values.size(); i++) {
		int newValue =	Integer.parseInt(values.get(i).getText());
			
			sum = sum + newValue;
		}
System.out.println(sum);
int oldValue = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
Assert.assertEquals(sum, oldValue);

	}

}
