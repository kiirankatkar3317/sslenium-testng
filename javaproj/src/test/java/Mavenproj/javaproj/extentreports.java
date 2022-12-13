package Mavenproj.javaproj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class extentreports {
	ExtentReports er;
	
	@BeforeTest
public void extentdemo() {
		
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	@SuppressWarnings("unused")
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Kiran Test");
	reporter.config().setDocumentTitle("Test Results");
	
	er = new ExtentReports();
	er.attachReporter(reporter);
	er.setSystemInfo("tester", "Kiran Katkar");
	
	
	}

@SuppressWarnings("unused")
@Test
public void demo() {
	ExtentTest test = er.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("test failed dur to code");
		er.flush();
	}

}

