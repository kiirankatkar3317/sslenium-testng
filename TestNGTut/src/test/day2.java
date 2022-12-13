package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day2 {
@Test(groups= {"kiran"})
	public void Mobilehomeloan() {
		System.out.println("This is mobile testhomeloan");

	}
@Test	
	public void Apihomeloan() {
		System.out.println("This is Api testhomeloan");

	}

@BeforeClass	
public void Beforeclasstest() {
	System.out.println("This is Beforeclasstest");

}

@AfterClass	
public void Afterclasstest() {
	System.out.println("This is Afterclasstest");

}
@Test(dataProvider= "getData")	
	public void Webhomeloan(String uname, String pass) {
		System.out.println("This is Web testhomeloan");
		System.out.println(uname);
		System.out.println(pass);

	}

@DataProvider
public Object[][] getData() {
	Object[][] data = new Object[3][2];
	data[0][0]= "username";
	data[0][1]= "password";
	
	data[1][0]= "username1";
	data[1][1]= "password1";
	
	data[2][0]= "username2";
	data[2][1]= "password2";
	
	return data;
	
}

}
