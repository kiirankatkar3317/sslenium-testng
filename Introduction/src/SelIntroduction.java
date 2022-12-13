//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {
public static void main(String[] args ){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
	//WebDriver driver = new ChromeDriver();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getCurrentUrl());
	//driver.close();
	driver.quit();
	
}
}