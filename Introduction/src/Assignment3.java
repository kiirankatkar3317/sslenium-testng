import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	@SuppressWarnings({ "unused", "null" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		int j=0;
		String[] value = {};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
		WebElement dropdownList = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select dropDown = new Select(dropdownList);
		dropDown.selectByIndex(2);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//div/label/span/input")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4[class='card-title'] a")));
		List<WebElement> all = driver.findElements(By.cssSelector("h4[class='card-title'] a"));
for(int i = 0;i<all.size();i++) {
	String product = all.get(i).getText();
	System.out.println(product);
	List<String> kk = Arrays.asList(value);
	if(kk.contains(product)) {
		j++;
		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
		if(j==product.length()) {
			break;
		}
	}
}
		
//		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();

	}

}
