package Frameworkproj.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frameworkproj.Maintest.BaseTest;
import Frameworkproj.PageObject.CartPage;
import Frameworkproj.PageObject.CheckoutPage;
import Frameworkproj.PageObject.ConfirmationPage;
import Frameworkproj.PageObject.OrderPage;
import Frameworkproj.PageObject.ProductCatalouge;

public class Objdata extends BaseTest{
	String cartselectedprod = "zara coat 3";
	
	@Test(dataProvider="getData" , groups = {"Purchase"})	
	public void submitOrder(HashMap<String,String> input) throws InterruptedException{
		// TODO Auto-generated method stub
		String country ="india";
		ProductCatalouge  productcatalouge =landingPage.Login(input.get("email"), input.get("pass"));
		Thread.sleep(3000);
		productcatalouge = new ProductCatalouge(driver);
		productcatalouge.addProductToCart(input.get("prod"));
		CartPage cartpage = productcatalouge.ClickOnCart();
		
		boolean match = cartpage.MatchTest(input.get("prod"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage =  cartpage.ClickOnBuy();
		
		ConfirmationPage confirmationpage = checkoutpage.PlaceOrder(country);
		
		String confirmMessege1 = confirmationpage.ConfirmPage();
		Assert.assertTrue(confirmMessege1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		landingPage.clickOnSignOut();	
	
	}


@Test(dependsOnMethods= {"submitOrder"})
public void HistoryOfOrders() {
	ProductCatalouge productcatalouge = landingPage.Login("kirankatkar3317@gmail.com", "Kiran@1994");
	OrderPage orderpage = productcatalouge.ClickOnOrders();
	Assert.assertTrue(orderpage.CheckOrder(cartselectedprod));	
}
	
	@DataProvider
	//object parametrization
//	public Object[][] getData() {	
	//	return new Object[][] { {"kirankatkar3317@gmail.com","Kiran@1994","ZARA COAT 3"},{"kirankatkar3318@gmail.com","Kiran@1995","ADIDAS ORIGINAL"}};
	
	//Hashmap technique
	

	//	HashMap<String,String> map = new HashMap<String,String>();
	
//	map.put("email", "kirankatkar3317@gmail.com");
//	map.put("pass", "Kiran@1994");
//	map.put("prod", "ZARA COAT 3");
//	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	
//	map1.put("email", "kirankatkar3318@gmail.com");
//	map1.put("pass","Kiran@1995");
//	map1.put("prod","ADIDAS ORIGINAL");
//		
//	return new Object[][] {{map},{map1}};
	
	public Object[][] getData() throws IOException{
		List<HashMap<String,String>> data = jsontoHashmap(System.getProperty("user.dir")+"\\src\\test\\java\\Frameworkproj\\data\\Submitorderdata.json");

		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
}
