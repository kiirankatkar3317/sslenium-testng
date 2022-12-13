import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	@Test
	public void Homepagetest() throws IOException {
DesiredCapabilities cap = new DesiredCapabilities();
//cap.setBrowserName("chrome");
//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS , true);
cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"), cap);
driver.get("https://www.google.co.in/");
String tile =driver.getTitle();
System.out.println(tile);
	}




}
