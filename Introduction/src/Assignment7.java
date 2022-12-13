import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.cssSelector("table[class='table-display'] tr")).get(0).findElements(By.tagName("th")).size());
		System.out.println(driver.findElements(By.cssSelector("table[class='table-display'] tr")).get(1).findElements(By.tagName("td")).size());
		List<WebElement> names = driver.findElements(By.cssSelector("table[class='table-display'] tr")).get(1).findElements(By.tagName("td"));
		System.out.println(names.get(1).getText());
		System.out.println(names.get(2).getText());
		//table[class="table-display"] tr:nth-child(2)
		
		
		WebElement tableScope = driver.findElement(By.cssSelector("table[class='table-display']"));
		
		System.out.println(tableScope.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		
		List<WebElement> secondRow = tableScope.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
		
		System.out.println(secondRow.get(0).getText());
		
	}

}
