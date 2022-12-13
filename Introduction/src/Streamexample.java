import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Streamexample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","c:\\Users\\LENOVO\\OneDrive\\Desktop\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

driver.findElement(By.cssSelector("th[aria-sort='descending']")).click();

List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

List<String> selectedVeggies = veggies.stream().map(s->s.getText()).collect(Collectors.toList());

List<String> updatedVeggies = selectedVeggies.stream().sorted().collect(Collectors.toList());

Assert.assertTrue(selectedVeggies.equals(updatedVeggies));

List<String> actualVeggies = veggies.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggies(s)).collect(Collectors.toList());

actualVeggies.stream().forEach(a->System.out.println(a));
	}
	

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub
String priceValue =	s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		return priceValue;
	}

}
