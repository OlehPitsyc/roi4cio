package SolutionsPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithAllSolutions {
	private WebDriver driver;

	@FindBy(xpath = "//*[@class='ui center aligned header']/span")
	private WebElement quantityOFProductOnProductsPage;

	@FindBy(css = ".ui.card")
	private List<WebElement> cardsOnThePage;

	@FindBy(css = ".list-more.products")
	private WebElement loadMoreButton;

	public PageWithAllSolutions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String quantityOfSolutions() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".quantity")));
		return quantityOFProductOnProductsPage.getText();

	}
	public int sizeOfSoluttionsCardsOnTheSolutionsPage() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".quantity")));
		return cardsOnThePage.size();
	}

	public void clickOnLoadMoreButton() {
		for (;;) {
			if (loadMoreButton.isDisplayed()) {
				loadMoreButton.click();
				break;
			} else {
				break;
			}
		}
	}


}
