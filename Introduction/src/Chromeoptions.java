
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		//Proxy proxy = new Proxy();
		//proxy.setHttpProxy("192.168.21.36:8080");
		//option.setCapability("proxy", proxy);
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
		
		
		option.setExperimentalOption("excludeswitches", Arrays.asList("disable-popup-blocking"));
		
		
		Map<String,Object> prefs = new HashMap();
		prefs.put("download.default_directory", "/block/kk");
		option.setExperimentalOption("prefs", prefs);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("198.10.12.122:8080");
		option.setExperimentalOption("proxy", proxy);
		
	}

}
