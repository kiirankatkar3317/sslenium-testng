package Frameworkproj.AbstractionForReuse;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Frameworkproj.PageObject.CartPage;
import Frameworkproj.PageObject.LandingPage;
import Frameworkproj.PageObject.OrderPage;
import Frameworkproj.PageObject.ProductCatalouge;

public class AbstractionModel {
	public WebDriver driver;
	public OrderPage orderpage;
	public CartPage cartpage;
	public ProductCatalouge productcatalouge;
	
	public LandingPage landingPage;
	
	@FindBy(xpath="//button[@class='btn btn-custom'] [text()=' Sign Out ']")
	WebElement SignOut;

	
	@FindBy(css="#toast-container")
	public WebElement loginAndlogoutmsg;
	
	@FindBy(css = ".ta-results")
	public WebElement countryresults;
	
	@FindBy(css = "div[class*='mb-3']")
	public WebElement landingpagewait;
	
	@FindBy(css = ".ng-animating")
	public WebElement addtocartspinner;
	
	@FindBy(css = ".toast-message")
	public WebElement addtocartflashmessege;
	
	@FindBy(css = "div[class='cartSection'] h3")
	public WebElement cartpagewait;
	
	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartbutton;
	
	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement orderpageclick;
	
	@FindBy(css = "[#toast-message']")
	WebElement orderplacedmsg;
	
	
	public AbstractionModel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void ElementToVisible(WebElement elem) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public void ElementToInvisible(WebElement elem) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public CartPage ClickOnCart() {
		ElementToInvisible(addtocartspinner);
		ElementToInvisible(addtocartflashmessege);
		cartbutton.click();
		cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage ClickOnOrders() {
		orderpageclick.click();	
		 orderpage = new OrderPage(driver);
		return orderpage;
		
		
	}
	
	public void clickOnSignOut()
	{
		SignOut.click();
		ElementToInvisible(loginAndlogoutmsg);
		
	}
	
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
}
