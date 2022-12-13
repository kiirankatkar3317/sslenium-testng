import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cartmult {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		int j = 0;
		String[] name = {"Cucumber", "Beetroot", "Brocolli"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Thread.sleep(3000);

		List<WebElement> productRequired = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < productRequired.size(); i++) {

			String[] product = productRequired.get(i).getText().split("-");
			String actualProduct = product[0].trim();

			System.out.println(actualProduct);
			List productName = Arrays.asList(name);

			if (productName.contains("actualProduct")) {
				j++;
				
				driver.findElements(By.cssSelector("div[class = 'product-action'] button")).get(i).click();

				if (j == 3) {
					break;
				}
			}
		}
	}

}
