package roi4cio.add.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductPage {
	private WebDriver driver;

	@FindBy(id = "pr-title")
	private WebElement titleOfProduct;

	@FindBy(id = "pr-short")
	private WebElement shortDiscription;

	@FindBy(id = "pr-description_ifr")
	private WebElement description;

	@FindBy(xpath = "//input[@value='2']")
	private WebElement deliveryType;

	@FindBy(xpath = "//*[@class='ui fluid dropdown numbers all left-column selection multiple'])[3]")
	private WebElement dropdawnUserParameters;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);

	}

	public void addTitleForProduct(String title) {
		titleOfProduct.sendKeys(title);
	}

	public void addShortDescroption(String shortDecs) {
		shortDiscription.sendKeys(shortDecs);
	}

	public void addtDescroption(String Decs) {
		description.sendKeys(Decs);
	}

	public void selectCheckBox() {
		deliveryType.click();
	}
// select value in dropdawn
	public void selecetUserParameters(String value) {
		Select select = new Select(dropdawnUserParameters);
		select.selectByValue(value);

	}
}
