import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Limitscope {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement FooterDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(FooterDriver.findElements(By.tagName("a")).size());
		
		 WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		 System.out.println(columnDriver.findElements(By.tagName("a")).size());
		 
		
		 
		 for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++){
			 String clickandNext = Keys.chord(Keys.CONTROL,Keys.ENTER);
			 
			 columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickandNext);
			
			 
			 
		 }
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 
		 while(it.hasNext()){
			 
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
		 }
		
	}

}
