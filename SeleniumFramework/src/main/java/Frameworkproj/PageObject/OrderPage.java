package Frameworkproj.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Frameworkproj.AbstractionForReuse.AbstractionModel;

public class OrderPage extends AbstractionModel{
	WebDriver driver;
	public OrderPage orderpage;

	
	@FindBy(css = "[class=ng-star-inserted] td:nth-child(3)")
	List<WebElement> orderonorderpage;

	public OrderPage(WebDriver driver) {
        super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> FetchOrders() {
		return orderonorderpage;
		
	}
	public boolean CheckOrder(String prodnm) {
boolean match = FetchOrders().stream().anyMatch(prod->prod.getText().equals(prodnm));
return match;
	}
	
}

