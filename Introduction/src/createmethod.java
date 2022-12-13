
public class createmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
createmethod c = new createmethod();
String name = c.getData();
System.out.println(name);

createmethod2 c2 = new createmethod2();
System.out.println(c2.getUserData());

String name1 = getData1();
System.out.println(name1);


	}

	
	
	
	public String getData() {
		System.out.println('k');
		return "rahul kirab";
	}
	
	public static String getData1() {
		System.out.println('P');
		return "Dpoi Ananat";
	}
}
