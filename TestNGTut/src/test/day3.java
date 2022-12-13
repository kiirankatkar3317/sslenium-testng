package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	@Test
	public void Apilogin() {
		System.out.println("This is Api Login");
	}
	
	@BeforeMethod
	public void Beforemethodtest() {
		System.out.println("This is Beforemethodtest");

	}
	
	@AfterMethod
	public void Aftermethodtest() {
		System.out.println("This is Aftermethodtest");

	}
	
	@Test(groups = {"kiran"})
	public void Mobilelogin() {
		System.out.println("This is mobile Login");

	}
	@Test
	public void Weblogin() {
		System.out.println("This is web Login");
	}
}
