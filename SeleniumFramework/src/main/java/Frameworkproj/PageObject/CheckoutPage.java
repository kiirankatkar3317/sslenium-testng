package Frameworkproj.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Frameworkproj.AbstractionForReuse.AbstractionModel;

public class CheckoutPage extends AbstractionModel{
	
	WebDriver driver;
	
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = ".ta-results button:last-child")
	WebElement selectcountry;
	
	@FindBy(css = "div[class='actions'] a")
	WebElement placeorder;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public ConfirmationPage PlaceOrder(String Country) {
		Actions a = new Actions(driver);
		a.sendKeys(country,Country).build().perform();
		ElementToVisible(countryresults);
		selectcountry.click();
		placeorder.click();
		ConfirmationPage confirmationpage =new ConfirmationPage(driver);
		return confirmationpage;
	}
}
