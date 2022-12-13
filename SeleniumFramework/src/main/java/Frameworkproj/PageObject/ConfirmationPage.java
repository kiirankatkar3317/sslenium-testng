package Frameworkproj.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Frameworkproj.AbstractionForReuse.AbstractionModel;

public class ConfirmationPage extends AbstractionModel{
public WebDriver driver;
public OrderPage orderpage;

@FindBy(css=".hero-primary")
WebElement Messege;

public ConfirmationPage(WebDriver driver) {
	
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
public String ConfirmPage() {
	String confirmMessege = Messege.getText();
	return confirmMessege;
	
}



}