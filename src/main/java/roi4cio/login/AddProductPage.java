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

import roi4cio.add.product.ProductModel;

public class AddProductPage {
	private WebDriver driver;

	@FindBy(id = "pr-title")
	private WebElement titleOfProduct;

	@FindBy(xpath = "(//*[@tabindex='0'])[3]")
	private WebElement country;

	@FindBy(xpath = "(//*[@class='clearAlloption'])[1]")
	private WebElement clearAllSelectedCountry;

	@FindBy(xpath = "(//*[@tabindex='0'])[4]")
	private WebElement category;

	@FindBy(css = ".menu.three-column.transition.visible >.item")
	private List<WebElement> selectCategory;

	@FindBy(xpath = "(//*[@type='checkbox'])[1]")
	private WebElement toggle;

	@FindBy(xpath = "//*[@class='ui toggle checkbox']")
	private List<WebElement> delivery;

	@FindBy(css = ".ui.toggle.checkbox input[type='checkbox']")
	private List<WebElement> deliveryCheckBoxList;

	@FindBy(id = "pr-short")
	private WebElement shourtDescription;

	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement save;

	@FindBy(xpath = ("//*[@class='two fields']"))
	private WebElement errorMessageOnCreateProductPage;

	@FindBy(xpath = "(//*[@href='en/my-data/my-products/add-product/'])[2]")
	private WebElement changeLanguageInEnglish;

	@FindBy(xpath = "//*[@class='modal_template_1']")
	private WebElement confirmationPopup;

	@FindBy(xpath = "(//*[@class='ui teal button undefined'])[1]")
	private WebElement yesButton;

	@FindBy(xpath = "//*[@id='c78']")
	private WebElement englishAddProductPage;

	@FindBy(xpath = "//*[@class='ui segment']")
	private WebElement listWithProducts;

	public AddProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void addTitleForProduct(String title, String shourt) {
		titleOfProduct.sendKeys(title);
		shourtDescription.sendKeys(shourt);
	}

	public void selectDeliveryType() {
//		WebDriverWait waiter = new WebDriverWait(driver, 10);
//		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui.corner.labeled.input>#pr-short")));
		toggle.click();
	}

	public MyProductsPage save() {
		clickSaveButton();
		return new MyProductsPage(driver);
	}

	public void clickSaveButton() {
		save.click();
	}

	public String textErrorMessage() {
		return errorMessageOnCreateProductPage.getText();
	}

	private List<String> getValueDeliveryType() {
		return delivery.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	public void selectDeliveryType(List<String> delivery) {
		List<String> deliveryValue = getValueDeliveryType();
		for (String findElementDelivery : delivery) {
			if (delivery.isEmpty()) {
				break;}
			else {
				int index = deliveryValue.indexOf(findElementDelivery );
				deliveryCheckBoxList.get(index).click();
				break;
			}
		}
	}

	public void clickOnCategory() {
		category.click();
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-value='1']")));
	}

	private List<String> getValueFromDropdawnCategoty() {
		return selectCategory.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	public void selectValueFromDropdawnCategory(List<String> categoria) {
		List<String> valuesInCategoryDropdown = getValueFromDropdawnCategoty();
		for (String ñategoryDropdown : categoria) {
			if (categoria.isEmpty()) {
				break;
			} else {
				int index = valuesInCategoryDropdown.indexOf(ñategoryDropdown);
				selectCategory.get(index).click();
				break;

			}
		}
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

	public void addProduct(ProductModel filledallmandatoryfields) {
		titleOfProduct.sendKeys(filledallmandatoryfields.getTitle());
		selectDeliveryType(filledallmandatoryfields.getDeliveryType());
		category.click();
		selectValueFromDropdawnCategory(filledallmandatoryfields.getCategory());

	}
}
