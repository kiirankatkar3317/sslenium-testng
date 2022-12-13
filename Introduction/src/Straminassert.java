import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Straminassert {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies =driver.findElements(By.xpath("//tr/td[1]"));
		
List<WebElement> filterdVeggies	=veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
Assert.assertEquals(veggies.size(), filterdVeggies.size());
	}

}
