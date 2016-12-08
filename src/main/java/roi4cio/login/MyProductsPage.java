package roi4cio.login;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProductsPage {
	@FindBy(css = ".ui.teal")
	private WebElement addProducts;

	@FindBy(css = "table tbody tr td:nth-of-type(1)")
	private List<WebElement> prodNames;

	private WebDriver driver;

	public MyProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		waitForAddProductButton();
	}

	public AddProductPage addProduct() {
		waitForAddProductButton();
		addProducts.click();
		return new AddProductPage(driver);
	}
	
	private void waitForAddProductButton() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".add")));
	}

	public List<String> productNameList() {
		return prodNames.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<String> productTable() {
		// TODO Auto-generated method stub
		return null;
	}
}