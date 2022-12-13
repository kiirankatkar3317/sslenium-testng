package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	By loginButton = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("div[class='text-center'] h2");
	By nav = By.cssSelector("div[role$='navigation']");
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement login() {
		return driver.findElement(loginButton);
	}
	
	public WebElement Title() {
		return driver.findElement(title);
	}
	
	public WebElement Nav() {
		return driver.findElement(nav);
	}
}
