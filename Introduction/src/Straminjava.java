import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class Straminjava {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("Kiran");
		list.add("Abhijita");
		list.add("Anant");
		list.add("Asmita");
		list.add("Anvi");

		System.out.println(list.size());
        int count = 0;
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			if (name.startsWith("A")) {
				System.out.println(name);
                count++;
			}
		}
		System.out.println(count);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void Streamtest() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Kiran");
		list1.add("Abhijita");
		list1.add("Anant");
		list1.add("Asmita");
		list1.add("Anvi");		
		
		long c = list1.stream().filter(s-> s.startsWith("A")).count();
		System.out.println(c);
	

long d = Stream.of("Dipak","Raju","Ashu","Poonam").filter(s->s.startsWith("R")).count();
System.out.println(d);


long u = Stream.of("Dipak","Raju","Ashu","Poonam").filter(s->
{
s.startsWith("R");
return false;
}).count();
System.out.println(u);

list1.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
list1.stream().filter(s->s.endsWith("a")).limit(1).forEach(s->System.out.println(s));
list1.stream().filter(s->s.contains("K")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

ArrayList<String> list2 = new ArrayList<String>();
list2.add("Kiran");
list2.add("Abhijita");
list2.add("Anant");

List<String> names1 = Arrays.asList("Aatish","Dharesh","Atul","Vijay");

names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
Stream<String> ls = Stream.concat(names1.stream(), list2.stream());
//ls.sorted().forEach(s->System.out.println(s));
boolean b=ls.anyMatch(s->s.equalsIgnoreCase("Aatish"));
System.out.println(b);
Assert.assertTrue(b);



	}
@SuppressWarnings("unused")
@Test
public void StreamCollect() {
	
List<String> ls2 = Stream.of("Anshul","Prashanti","Rani","Vedamtam").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(ls2.get(0));

List<Integer> numbers = Arrays.asList(1,6,5,4,5,4,2,1);

List<Integer> Int = numbers.stream().distinct().sorted().collect(Collectors.toList());
System.out.println(Int.get(2));
//numbers.stream().distinct().sorted().limit(2).forEach(s->System.out.println(s));

}



}
