import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativelocatorsnew {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
WebElement label =		driver.findElement(By.cssSelector("div[class='form-check'] label[class='form-check-label']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(label)).click();
		
WebElement label2 =	driver.findElement(By.cssSelector("label[for='exampleFormControlSelect1']"));

driver.findElement(with(By.tagName("select")).below(label2)).click();


WebElement label3 = driver.findElement(By.id("inlineRadio1"));
driver.findElement(with(By.tagName("label")).toRightOf(label3)).getText();

System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(label3)).getText());


	}

}
