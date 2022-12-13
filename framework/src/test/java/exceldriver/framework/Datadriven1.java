package exceldriver.framework;

import java.io.IOException;
import java.util.ArrayList;

public class Datadriven1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Exceldriven e = new Exceldriven();
ArrayList data = e.getData("kk");
System.out.println(data.get(1));


	}

}
