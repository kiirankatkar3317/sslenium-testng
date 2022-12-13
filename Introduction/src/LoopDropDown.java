import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoopDropDown {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver" , "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			
			
			
			
			System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
			Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
			driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).click();
			System.out.println(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());
			Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=SeniorCitizenDiscount]")).isSelected());

			System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
			
			driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
			for(int i=0;i<5;i++) {
				
				driver.findElement(By.id("hrefIncAdt")).click();
			}
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
			driver.findElement(By.cssSelector("input[value='Done']")).click();
	}

}
