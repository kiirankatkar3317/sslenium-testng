import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String window1 = it.next();
		String window2 = it.next();	
		System.out.println(driver.switchTo().window(window1).getCurrentUrl());
		System.out.println(driver.switchTo().window(window2).getCurrentUrl());
		driver.switchTo().window(window1);
		System.out.println(driver.findElement(By.cssSelector("a[href='/windows/new']")).getText());
		driver.switchTo().window(window2);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
	}

}
