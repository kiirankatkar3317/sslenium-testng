import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> productRequired = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		for(int i=0; i<productRequired.size(); i++) {
			String product = productRequired.get(i).getText();
			System.out.println(product);
			if(product.contains("Cucumber")) {
				driver.findElements(By.cssSelector("div[class = 'product-action'] button")).get(i).click();
			}
		}

	}

}
