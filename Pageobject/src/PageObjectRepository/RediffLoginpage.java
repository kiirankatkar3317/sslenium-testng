package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginpage {
	//objectpattern

	WebDriver driver;
	
	public RediffLoginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By username = By.xpath("//input[@id='login1']");
	By password = By.id("password");
	By button = By.name("proceed");
	By link = By.xpath("//a[@title='Create new Rediffmail account'] //u");
	
	
	public WebElement Emailid() {
		return driver.findElement(username);
	}
	
	public WebElement Pass() {
		return driver.findElement(password);
	}
	
	public WebElement Submit() {
		return driver.findElement(button);
	}
	
	public WebElement newlink() {
		return driver.findElement(link);
	}
}
