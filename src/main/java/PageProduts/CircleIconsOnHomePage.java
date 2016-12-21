package PageProduts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CircleIconsOnHomePage{
	private WebDriver driver;
	
	@FindBy(xpath = "(//div[@class='column'])[1]/h4/span")
	private WebElement amountOfProducts;

	@FindBy(css = "//*[@class='ui secondary  menu']/a[1]")
	private WebElement productsButton;
	
	public CircleIconsOnHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	
	public String numberOfProduct() {
		return amountOfProducts.getText();


	}

	public PageWithAllProducts goToProductsPage() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='column'])[1]/h4/span")));
		productsButton.click();
		return new PageWithAllProducts(driver);
	}
}
