import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jdbcconn {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" +host+ ":" +port+ "/classicmodels" , "root", "root");
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from customers where customernumber = '103'");
		rs.next();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver_win32 (5).exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(rs.getString("customerName"));
		//System.out.println(rs.getString("customerName"));
		//System.out.println(rs.getString("contactLastName"));
		
		
		
		
		
	}

}
