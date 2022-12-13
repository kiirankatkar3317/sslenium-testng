package Frameworkproj.Tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wbtstwoframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String cartselectedprod = "ZARA COAT 3";

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://rahulshettyacademy.com/client");
driver.findElement(By.cssSelector("#userEmail")).sendKeys("kirankatkar3317@gmail.com");
driver.findElement(By.cssSelector("#userPassword")).sendKeys("Kiran@1994");
driver.findElement(By.cssSelector("#login")).click();

wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class*='mb-3']"))));

List <WebElement> productcard = driver.findElements(By.cssSelector("div[class*='mb-3']"));
WebElement prodname = productcard.stream().filter(productname->productname.findElement(By.xpath("//div//h5//b")).getText().equals(cartselectedprod)).findFirst().orElse(null);
prodname.findElement(By.cssSelector(".btn.w-10.rounded")).click();

wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));

driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='cartSection'] h3"))));

List<WebElement> cartproduct = driver.findElements(By.cssSelector("div[class = 'cartSection'] h3"));

boolean match = cartproduct.stream().anyMatch(actualproductname -> actualproductname.getText().equals(cartselectedprod));
Assert.assertTrue(match);


driver.findElement(By.cssSelector(".btn-primary:nth-last-of-type(2)")).click();
Actions a = new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

driver.findElement(By.cssSelector(".ta-results button:last-child")).click();
driver.findElement(By.cssSelector("div[class='actions'] a")).click();


String confirmMessege = driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(confirmMessege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}}
