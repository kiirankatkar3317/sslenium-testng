package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffSignuppage {
//objectfactory
	
	WebDriver driver;
	
	public RediffSignuppage(WebDriver driver) {
		
		this.driver = driver;
	   	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@maxlength='61']")
	WebElement username;
	
	@FindBy(id="newpasswd")
	WebElement password;
	
	public WebElement name() {
		return username;
		
	}
	
	public WebElement pass1() {
		return password;
		
	}
}
