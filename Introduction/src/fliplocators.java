import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fliplocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:\\\\Users\\\\LENOVO\\\\OneDrive\\\\Desktop\\\\chromedriver_win32\\\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.flipkart.com/?ef_id=61b33940a8a31bc8f3175bd2a9698b88:G:s&s_kwcid=AL!739!10!76347481385536!76347484024120&semcmpid=sem_F1167BY7_Brand_adcenter");


	}

}
