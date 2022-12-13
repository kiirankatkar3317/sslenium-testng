import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Streampagination {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("th[aria-sort='descending']")).click();
		Thread.sleep(2000L);

		List<String> newVeggies;
do {
		List<WebElement> veggies =driver.findElements(By.xpath("//tr/td[1]"));
		
newVeggies =veggies.stream().filter(veggy->veggy.getText().contains("Rice")).map(veggy->getPriceVeggies(veggy)).collect(Collectors.toList());
newVeggies.forEach(a->System.out.println(a));
if(newVeggies.size()<1) {
	driver.findElement(By.cssSelector("[aria-label='Next']")).click();
}
	}while(newVeggies.size()<1);
	}

	@SuppressWarnings("unused")
	private static String getPriceVeggies(WebElement veggy) {
	String price = veggy.findElement(By.xpath("//tr/td[2]")).getText();
		return price;
	}

}
