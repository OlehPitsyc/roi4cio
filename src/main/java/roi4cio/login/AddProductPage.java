package roi4cio.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {
	private WebDriver driver;

	@FindBy(id = "pr-title")
	private WebElement titleOfProduct;

	@FindBy(id = "pr-short")
	private WebElement shourtDescription;

	@FindBy(xpath = "(//*[@type='checkbox'])[1]")
	private WebElement toggle;

	@FindBy(xpath = "(//*[@type='checkbox'])[2]")
	private WebElement toggle1;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement save;

	// @FindBy(xpath =
	// "//select[@name='tx_agiliwayroi_products[product][categories][]']")
	// private WebElement category;

	@FindBy(xpath = "(//*[@tabindex='0'])[4]")
	private WebElement category;

	@FindBy(xpath = "(//*[@tabindex='0'])[3]")
	private WebElement country;

	@FindBy(xpath = "//*[@data-value='1']")
	private WebElement category1;

	@FindBy(xpath = ("//*[@class='two fields']"))
	private WebElement errorMessageOnCreateProductPage;

	@FindBy(xpath = "//*[@class='ui segment']")
	private WebElement listWithProducts;

	@FindBy(xpath = "(//*[@class='clearAlloption'])[1]")
	private WebElement clearAllSelectedCountry;

	@FindBy(xpath = "(//*[@href='en/my-data/my-products/add-product/'])[2]")
	private WebElement changeLanguageInEnglish;

	@FindBy(xpath = "//*[@class='modal_template_1']")
	private WebElement confirmationPopup;

	@FindBy(xpath = "(//*[@class='ui teal button undefined'])[1]")
	private WebElement yesButton;

	@FindBy(xpath = "//*[@id='c78']")
	private WebElement englishAddProductPage;

	public AddProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public void addTitleForProduct(String title, String shourt) {
		titleOfProduct.sendKeys(title);
		shourtDescription.sendKeys(shourt);

	}

	public void clickOneToggle() {
		toggle.click();
	}

	public void saveButtonClick() {
		save.click();
	}

	public String textErrorMessage() {
		return errorMessageOnCreateProductPage.getText();
	}

	public void clickOnTwoToggle() {
		toggle.click();
		toggle1.click();
	}

	public void clickOnCategore() {
		category.click();
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-value='1']")));
		category1.click();
		// Select categoryOfProduct = new Select(category);
		// categoryOfProduct.selectByValue("3");
	}

	public boolean myProductsList() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='ui segment']")));
		return listWithProducts.isDisplayed();
	}

	public void selectCountry() {
		country.click();
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='menu two-column transition visible']")));
		clearAllSelectedCountry.click();
	}

	public void clickOnFlag() {
		changeLanguageInEnglish.click();
	}

	public boolean Popup() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='modal_template_1']")));
		return confirmationPopup.isDisplayed();
	}

	public void clickOnYesButton() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='modal_template_1']")));
		yesButton.click();

	}

	public boolean englishPageAddProduct() {
		return englishAddProductPage.isDisplayed();
	}
}
