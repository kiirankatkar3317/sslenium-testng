package Frameworkproj.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Frameworkproj.AbstractionForReuse.AbstractionModel;

public class LandingPage extends AbstractionModel{
	String url = "https://rahulshettyacademy.com/client";
	public WebDriver driver;
	

	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css="input[id='userEmail']")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="#toast-container")
	WebElement loginerrormessage;
	
//	@FindBy(xpath="//button[@class='btn btn-custom'] [text()=' Sign Out ']")
//	WebElement SignOut;
	
	
	public ProductCatalouge Login(String e, String p) {
		userEmail.sendKeys(e);
		userPassword.sendKeys(p);
		login.click();
		ProductCatalouge productcatalouge = new ProductCatalouge(driver);
		return productcatalouge;
	}
	

	public String getErrorMessege() {
	//	ElementToInvisible();
		ElementToVisible(loginerrormessage);
		String error = loginerrormessage.getText();
		return error;
	}
	public void Goto(){
		driver.get(url);
	}
	
	
	
//	public ProductCatalouge clickOnSignOut()
//	{
//		SignOut.click();
//		ProductCatalouge productcatalouge = new ProductCatalouge(driver);
//		return productcatalouge;
//	}
}

