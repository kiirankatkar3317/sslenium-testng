package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
    public Properties prop;
	public WebDriver DriverIntialization() throws IOException {
		 prop = new Properties();
	//	 String Baseurl = prop.getProperty(url);
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\LENOVO\\eclipse-workspace\\e2eproject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"c:\\\\Users\\\\LENOVO\\\\OneDrive\\\\Desktop\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
return driver;
	}

}
