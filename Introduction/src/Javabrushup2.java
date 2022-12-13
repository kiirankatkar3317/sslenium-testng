
public class Javabrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String kk = "Kiran Katkar ANANT";
		String kk2 = "Katkar";
		
		
		String s1 = new String("Kiran");
		String s2 = new String("Katkar");
		
		String[] splittedString = kk.split("Katkar");
		System.out.println(splittedString[0].trim());
		System.out.println(splittedString[1].trim());
		
		for(int i = 0; i < kk.length(); i++)
		{
			System.out.println(kk.charAt(i));
		}
		
		for(int i = kk.length()-1 ; i >= 0 ; i--)
		{
			System.out.println(kk.charAt(i));
		}
	}

}
