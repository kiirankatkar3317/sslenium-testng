import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhand {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String window1 = it.next();
		String window2 = it.next();
		driver.switchTo().window(window2);
		String kk =driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim());
		driver.switchTo().window(window1);
		driver.findElement(By.id("username")).sendKeys(kk);
		
	}
//	driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
}
