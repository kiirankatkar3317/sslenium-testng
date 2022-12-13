package stack;

import java.io.IOException;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CheckTitle1 {
@Test
public void titleCheck() throws IOException {
	MutableCapabilities cap = new MutableCapabilities();
	
	WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),cap);
	driver.get("www.google.com");
	Assert.assertTrue(driver.getTitle().matches("Google"));
	
	
}
	
}
