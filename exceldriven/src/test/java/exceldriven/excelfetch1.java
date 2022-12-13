package exceldriven;

import java.io.IOException;
import java.util.ArrayList;

public class excelfetch1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Datadeivenkk data = new Datadeivenkk();
ArrayList<String> li = data.getdata1("kk");

System.out.println(li.get(0));
System.out.println(li.get(1));
System.out.println(li.get(2));
System.out.println(li.get(3));

	}

}
