package Frameworkproj.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Frameworkproj.AbstractionForReuse.AbstractionModel;

public class CartPage extends AbstractionModel{

	WebDriver driver;
	
	@FindBy(css = "div[class = 'cartSection'] h3")
	List<WebElement> cartproduct;
	
	@FindBy(css = ".btn-primary:nth-last-of-type(2)")
	WebElement buynowbutton;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean MatchTest(String productname) {
		ElementToVisible(cartpagewait);
		boolean match = cartproduct.stream().anyMatch(actualproductname -> actualproductname.getText().equals(productname));
		return match;
	}
	public CheckoutPage ClickOnBuy() {
		buynowbutton.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}
}
