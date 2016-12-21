package ImplemantationsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithAllImplementation {
	private WebDriver driver;

	@FindBy(xpath = "//*[@class='ui center aligned header']/span")
	private WebElement quantityOFProductOnProductsPage;

	public PageWithAllImplementation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String quantityOfImplementations() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".quantity")));
		return quantityOFProductOnProductsPage.getText();

	}
}
