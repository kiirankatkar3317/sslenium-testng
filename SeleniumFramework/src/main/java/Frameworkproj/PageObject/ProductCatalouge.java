package Frameworkproj.PageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Frameworkproj.AbstractionForReuse.AbstractionModel;
public class ProductCatalouge extends AbstractionModel{
	
	   public WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class*='mb-3']")
	List<WebElement> productcard;
	
	
	
	By addtocartclick = By.cssSelector(".card-body button:last-of-type");
	
	public List<WebElement> getProductList() {
		return productcard;
		
	}
	
	public WebElement FindProduct(String cartprodname) {
		ElementToVisible(landingpagewait);
		WebElement prodname = productcard.stream().filter(productname->productname.findElement(By.xpath("//div//h5//b")).getText().equals(cartprodname)).findFirst().orElse(null);
        return prodname;

        
	}
	
	public ProductCatalouge FindProductandclick(String cart) {
		
		FindProduct(cart).findElement(addtocartclick).click();
		ProductCatalouge productcatalouge = new ProductCatalouge(driver);
		return productcatalouge;
		
	}
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);


	}

	
	
}

