package Frameworkproj.Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Frameworkproj.Maintest.BaseTest;
import Frameworkproj.Maintest.Retry;
//farmeworkpart3
public class ErrorMessegeValidationTest extends BaseTest{

@Test(retryAnalyzer = Retry.class)
	
	public void LoginCheck() throws IOException{
		// TODO Auto-generated method stub
landingPage.Login("kirankatkar33@gmail.com", "Kiran@94");
Assert.assertEquals( landingPage.getErrorMessege(), "Incorrect email or password..");
}
	
@Test
	
	public void Login() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
landingPage.Login("kirankatkar3317@gmail.com", "Kiran@1994");
landingPage.clickOnSignOut();
Thread.sleep(2000);

}

//@Test(dependsOnMethods= {"Login"})
//
//public void ValidationCartProduct() {
//productcatalouge= new ProductCatalouge(driver);
//productcatalouge.FindProductandclick("ZARA COAT 3");
//CartPage cartpage = productcatalouge.ClickOnCart();
//
//boolean match = cartpage.MatchTest("ZARA COAT 3");
//Assert.assertTrue(match);
//}
}