package Kiran.PageoObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kiran.Abstraction.AbstractionforReuse;

public class ProductCatalouge extends AbstractionforReuse {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productstovisible = By.cssSelector(".mb-3");
	By addproducttocart = By.cssSelector("button[class*= 'w-10 rounded']");

	@FindBy(css = ".mb-3")
	List<WebElement> Products;

	public List<WebElement> getProductList() {
		ElementToBeDisplayed(productstovisible);
		return Products;
	}

	public WebElement getProductByName(String prodname) {
		WebElement prod = getProductList().stream().filter(product -> product
				.findElement(By.cssSelector("div[class= 'card-body'] b")).getText().equals(prodname))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String prodname) {
		getProductByName(prodname).findElement(By.cssSelector("button[class*= 'w-10 rounded']")).click();
	}

}
