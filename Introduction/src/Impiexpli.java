import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Impiexpli {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> Veggies = driver.findElements(By.cssSelector("h4[class='product-name']"));
		for(int i=0;i<Veggies.size();i++) {
		String Veg = Veggies.get(i).getText();
		if(Veg.contains("Brocolli")) {
			driver.findElements(By.cssSelector("div[class = 'product-action'] button")).get(i).click();
			
		}
		}
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains (text(), 'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promocode")));
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");



driver.findElement(By.className(".promoBtn")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

}
