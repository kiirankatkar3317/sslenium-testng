package Kiran.PageoObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kiran.Abstraction.AbstractionforReuse;


public class LoadingPage extends AbstractionforReuse{
	
	WebDriver driver;
	
	public LoadingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement email;
	
	@FindBy(id = "userPassword")
	WebElement pass;
	
	@FindBy(id = "login")
	WebElement submit;
	
public void Login(String Email, String Password) {
	
	email.sendKeys(Email);
	pass.sendKeys(Password);
	submit.click();
	}

public void Goto() {
	
	driver.get("https://rahulshettyacademy.com/client");
}
}
