package roi4cio.add.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProducts {
	@FindBy(css=".add")
	private WebElement addProducts;
	
	private WebDriver driver;
	
	public MyProducts(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
	}
	
	public AddProductPage addProduct(){
		addProducts.click();
		return new AddProductPage(driver);
	}
}
