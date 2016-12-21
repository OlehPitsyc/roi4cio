package roi4cio.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ImplemantationsPage.PageWithAllImplementation;
import PageProduts.PageWithAllProducts;
import SolutionsPage.PageWithAllSolutions;
import SuppliersPage.PageWithAllSuppliers;
import VendorsPage.PageWithAllVendors;

public class HomePage {

	private WebDriver driver;

	@FindBy(className = "circular")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@class='ui secondary  menu']/a[1]")
	private WebElement productsButton;
	@FindBy(xpath = "(//*[@class='column'])[1]/h4/span")
	private WebElement amountOfProducts;

	@FindBy(xpath = "//*[@class='ui secondary  menu']/a[2]")
	private WebElement solutionsButton;
	@FindBy(xpath = "(//*[@class='column'])[1]/h4/span")
	private WebElement amountOfSolutions;

	@FindBy(xpath = "//*[@class='ui secondary  menu']/a[3]")
	private WebElement impamentationsButton;
	@FindBy(xpath = "(//*[@class='column'])[1]/h4/span")
	private WebElement amountOfImpementation;

	@FindBy(xpath = "//*[@class='ui secondary  menu']/a[4]")
	private WebElement suppliersButton;
	@FindBy(xpath = "(//*[@class='column'])[1]/h4/span")
	private WebElement amountOfSuppliers;

	@FindBy(xpath = "//*[@class='ui secondary  menu']/a[5]")
	private WebElement vendorsButton;
	@FindBy(xpath = "(//*[@class='column'])[1]/h4/span")
	private WebElement amountOfVendors;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage clickOnLoginIcon() {
		this.loginLink.click();
		return new LoginPage(driver);
	}

	public String numberOfSolutions() {
		return amountOfSolutions.getText();

	}

	public String numberOfImplementations() {
		return amountOfImpementation.getText();

	}

	public String numberOfSuppliers() {
		return amountOfSuppliers.getText();

	}

	public String numberOfVendors() {
		return amountOfVendors.getText();

	}

	public String numberOfProduct() {
		return amountOfProducts.getText();
	}

	public PageWithAllProducts goToProductsPage() {
		productsButton.click();
		return new PageWithAllProducts(driver);
	}
	public PageWithAllSolutions goToSolutionsPage() {
		productsButton.click();
		return new PageWithAllSolutions(driver);
	}
	public PageWithAllImplementation goToImplementationsPage() {
		productsButton.click();
		return new PageWithAllImplementation(driver);
	}
	public PageWithAllSuppliers goToSuppliersPage() {
		productsButton.click();
		return new PageWithAllSuppliers(driver);
	}
	public PageWithAllVendors goToVendorsPage() {
		productsButton.click();
		return new PageWithAllVendors(driver);
	}

}
