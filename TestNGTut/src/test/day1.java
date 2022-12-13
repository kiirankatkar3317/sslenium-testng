package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {
@Test(groups = {"kiran"})
	public void Mobiletestloan() {
		System.out.println("This is mobile test");
		Assert.assertTrue(false);
	}

@Test//(dependsOnMethods= {"Mobiletestloan"})
	public void Apitestloan() {
		System.out.println("This is Api test");
	}
@BeforeTest
public void Beforetesting() {
	System.out.println("This is Beforetest");
}

@AfterTest
public void Aftertesting() {
	System.out.println("This is Aftertest");
}

@Test(enabled=false)

	public void Webtestloan() {
		System.out.println("This is Web test");
	}

@Test(timeOut = 3000)
public void Mobiletestloan1() {
	System.out.println("This is mobile1 test");
}

@Test
public void Mobiletestloan2() {
	System.out.println("This is mobile2 test");
}
}
