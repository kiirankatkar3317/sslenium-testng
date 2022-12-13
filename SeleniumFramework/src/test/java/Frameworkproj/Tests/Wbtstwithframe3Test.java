package Frameworkproj.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import Frameworkproj.Maintest.BaseTest;
import Frameworkproj.PageObject.CartPage;
import Frameworkproj.PageObject.CheckoutPage;
import Frameworkproj.PageObject.ConfirmationPage;
import Frameworkproj.PageObject.OrderPage;
import Frameworkproj.PageObject.ProductCatalouge;
//farmeworkpart3
public class Wbtstwithframe3Test extends BaseTest{
	String cartselectedprod = "ZARA COAT 3";

String cartselectedprod1 ="zara coat 3";
	
	@Test
	
	public void submitOrder() throws IOException{
		// TODO Auto-generated method stub
	
		String country ="india";
ProductCatalouge productcatalouge = landingPage.Login("kirankatkar3317@gmail.com", "Kiran@1994");

productcatalouge.FindProductandclick(cartselectedprod);
CartPage cartpage = productcatalouge.ClickOnCart();

boolean match = cartpage.MatchTest(cartselectedprod);
Assert.assertTrue(match);
CheckoutPage checkoutpage =  cartpage.ClickOnBuy();

ConfirmationPage confirmationpage = checkoutpage.PlaceOrder(country);

String confirmMessege1 = confirmationpage.ConfirmPage();
Assert.assertTrue(confirmMessege1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//productcatalouge = landingPage.clickOnSignOut();
confirmationpage.clickOnSignOut();



	}


@Test(dependsOnMethods= {"submitOrder"})
public void HistoryOfOrders() throws InterruptedException {
	ProductCatalouge productcatalouge = landingPage.Login("kirankatkar3317@gmail.com", "Kiran@1994");
	OrderPage orderpage = productcatalouge.ClickOnOrders();
	Thread.sleep(5000);
	Assert.assertTrue(orderpage.CheckOrder(cartselectedprod1));	
}
}

