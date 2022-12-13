import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import.java.io.FileNotFoundException;

public class Globalvaluesdrive {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(C:\Users\LENOVO\eclipse-workspace\Corejava\src\data.properties);
prop.load(fis);
System.out.println(prop.getProperty("url"));
prop.setProperty("url", "www.yahoo.com");
System.out.println(prop.getProperty("url"));
FileOutputStream fos = new FileOutputStream(C:\Users\LENOVO\eclipse-workspace\Corejava\src\data.properties);
prop.store(fos, null);
 


	}

}
