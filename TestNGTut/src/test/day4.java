package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
@Test(groups="kiran")
	public void Mobilecarloan() {
		System.out.println("This is mobile testcarloan");

	}

@BeforeSuite
public void BeforeSuitetest() {
	System.out.println("This is BeforeSuitetest");

}

@AfterSuite
public void AfterSuitetest() {
	System.out.println("This is AfterSuitetest");

}

@BeforeMethod
public void Beforemethodtest() {
	System.out.println("This is Beforemethodtest");

}

@Test	
	public void Apicarloan() {
		System.out.println("This is Api testcarloan");

	}
@Test
@Parameters({"URL","APIKEY"})
	
	public void Webcarloan(String Weburl,String key) {
		System.out.println("This is Web testcarloan");
		System.out.println(Weburl);
		System.out.println(key);
	}
}
