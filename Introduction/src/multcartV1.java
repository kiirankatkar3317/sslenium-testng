import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multcartV1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	String [] Veggies = {"Brocolli","Cauliflower","Beetroot"};
		codeHide(driver, Veggies);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains (text(), 'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promocode")));
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
	
	}

	
	
	
	
	
	
	
	
	public static void codeHide(WebDriver driver, String[] Veggies) {
		int j = 0;
	List<WebElement> productName = driver.findElements(By.cssSelector("h4[class='product-name']"));
	for(int i=0;i<productName.size();i++) {
		String[] vegname = productName.get(i).getText().split("-");
		String Real = vegname[0].trim();
		System.out.println(Real);
		List vegList = Arrays.asList(Veggies);
		if(vegList.contains(Real)) {
			j++;
			driver.findElements(By.cssSelector("div[class = 'product-action'] button")).get(i).click();

			if(j==3) {
				break;
			}
		}
	}
	}
}
