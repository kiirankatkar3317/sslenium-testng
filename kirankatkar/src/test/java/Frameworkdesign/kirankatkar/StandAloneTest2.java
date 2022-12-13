package Frameworkdesign.kirankatkar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Kiran.PageoObject.LoadingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String cartselectedprod = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		driver.findElement(By.id("userEmail")).sendKeys("kirankatkar3317@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Kiran@1994");
		driver.findElement(By.id("login")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(productList);
		WebElement prod = productList.stream().filter(product -> product
				.findElement(By.cssSelector("div[class= 'card-body'] b")).getText().equals(cartselectedprod))
				.findFirst().orElse(null);

		prod.findElement(By.cssSelector("button[class*= 'w-10 rounded']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// ng-animating
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProduct = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match = cartProduct.stream()
				.anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(cartselectedprod));
		Assert.assertTrue(match);

		driver.findElement(By.cssSelector("div[class*='subtotal'] button")).click();
		Thread.sleep(2);
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("div[class='form-group'] input")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-results button:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".btnn")).click();
		String confirmMessege = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
