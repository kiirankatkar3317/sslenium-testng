package Frameworkproj.Maintest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Frameworkproj.PageObject.LandingPage;
import Frameworkproj.PageObject.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public ProductCatalouge productcatalouge;

	public WebDriver initializedriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Frameworkproj\\properties\\TestData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
				driver.manage().window().setSize(new Dimension(1440, 900));// full screen
			}
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\LENOVO\\Downloads\\geckodriver-v0.32.0-win-aarch64\\geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeTest(alwaysRun = true)
	public LandingPage loginPage() throws IOException {
		driver = initializedriver();
		landingPage = new LandingPage(driver);
		landingPage.Goto();
		return landingPage;
	}

	@AfterTest(alwaysRun = true)
	public void exitTest() throws IOException {
		driver.quit();
	}

//	public String getScreenAtReports(String testcasename, WebDriver driver) throws IOException {
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
//	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
//		//String png= System.currentTimeMillis()+ ".png";
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
//		FileUtils.copyFile(source,new File(destinationFile));
//		return destinationFile;
	}

	public List<HashMap<String, String>> jsontoHashmap(String Filepath) throws IOException {

		String jsondata = FileUtils.readFileToString(new File(Filepath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsondata,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
