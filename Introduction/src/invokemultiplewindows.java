import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class invokemultiplewindows {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it =window.iterator();
		String parentwindow = it.next(); 
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
String kk=	driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

driver.switchTo().window(parentwindow);
WebElement kk2= driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
kk2.sendKeys(kk);

//Screenshot of specific element
//File src = kk2.getScreenshotAs(OutputType.FILE);
//Fileutils.copyFile(src,new File("logo,png"));

//dimention of specific element
System.out.println(kk2.getRect().getDimension().getHeight());
System.out.println(kk2.getRect().getDimension().getWidth());

	}

}
