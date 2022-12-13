package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	By username = By.cssSelector("input[type='email']");
	By password = By.cssSelector("input[type='password']");
	By button = By.cssSelector("input[value='Log In']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement Username() {
		return driver.findElement(username);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}


	public WebElement Button() {
		return driver.findElement(button);
	}

}