import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticdropdown {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropDown= new Select(staticDropdown);
				dropDown.selectByIndex(2);
			//	System.out.println(dropDown.getFirstSelectedOption().getText());
				//dropDown.getFirstSelectedOption().click();
				//dropDown.selectByValue("USD");
				//System.out.println(dropDown.getFirstSelectedOption().getText());
				//dropDown.selectByVisibleText("INR");
				//System.out.println(dropDown.getFirstSelectedOption().getText());
				
				
				//enableing below is theother session do not conclude in this
			//	System.out.println(driver.findElement(By.cssSelector(".picker-second")).isEnabled());
				//driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
			//	System.out.println(driver.findElement(By.cssSelector(".picker-second")).isEnabled());
	}

}
