package Frameworkproj.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import Frameworkproj.PageObject.CartPage;
import Frameworkproj.PageObject.CheckoutPage;
import Frameworkproj.PageObject.ConfirmationPage;
import Frameworkproj.PageObject.LandingPage;
import Frameworkproj.PageObject.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wbtstwithframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String cartselectedprod = "ZARA COAT 3";
		String country ="india";

WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

LandingPage landingPage = new LandingPage(driver);
landingPage.Goto();
ProductCatalouge productcatalouge = landingPage.Login("kirankatkar3317@gmail.com", "Kiran@1994");

productcatalouge.FindProductandclick(cartselectedprod);
CartPage cartpage = productcatalouge.ClickOnCart();

boolean match = cartpage.MatchTest(cartselectedprod);
Assert.assertTrue(match);
CheckoutPage checkoutpage =  cartpage.ClickOnBuy();

ConfirmationPage confirmationpage = checkoutpage.PlaceOrder(country);

String confirmMessege1 = confirmationpage.ConfirmPage();
Assert.assertTrue(confirmMessege1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();

	}}
