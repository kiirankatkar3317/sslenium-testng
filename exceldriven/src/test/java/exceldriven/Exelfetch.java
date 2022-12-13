package exceldriven;

import java.io.IOException;
import java.util.ArrayList;

public class Exelfetch {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Datadriven d = new Datadriven();
ArrayList ae = d.getData("shops");
System.out.println(ae.get(0));
System.out.println(ae.get(1));
System.out.println(ae.get(2));
System.out.println(ae.get(3));

	}

}
