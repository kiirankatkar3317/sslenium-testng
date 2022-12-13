import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handlingCalenderUi {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");	
	    ChromeOptions options  = new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companions");
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("travel_date"))));
		driver.findElement(By.id("travel_date")).click();
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		System.out.println(count);

		
		while(!driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText().contains("July 2023")) {
			driver.findElement(By.cssSelector(".datepicker-days .next")).click();
		}
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			System.out.println(driver.findElements(By.className("day")).get(i).getText());
			if (text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

	}

}
