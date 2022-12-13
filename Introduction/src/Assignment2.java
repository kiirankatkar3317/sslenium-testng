import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

		
		@SuppressWarnings("unused")
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver" , "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
			driver.findElement(By.name("name")).sendKeys("Kiran katkar");
			driver.findElement(By.name("email")).sendKeys("Kirankatkar3317@gmail.com");
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Kiran8286");
			driver.findElement(By.id("exampleCheck1")).click();
			
			WebElement DropdownList = driver.findElement(By.id("exampleFormControlSelect1"));
			
			Select dropDown = new Select(DropdownList);
			dropDown.selectByIndex(1);
			dropDown.getFirstSelectedOption().click();
			driver.findElement(By.id("inlineRadio1")).click();
			driver.findElement(By.name("bday")).sendKeys("23-01-1258");
			driver.findElement(By.cssSelector(".btn.btn-success")).click();
			
	}

}
