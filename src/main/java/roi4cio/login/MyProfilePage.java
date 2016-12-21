package roi4cio.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ChangePasswordPage.ChangePasswordPage;
import LeftMenu.SiteMenu;

public class MyProfilePage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@href='moi-kabinet/moi-produkty/']")
	private WebElement myPage;

	@FindBy(xpath = "(//*[@href='login/?logintype=logout'])[2]")
	private WebElement logout;

	@FindBy(css = ".changepassword")
	private WebElement changePassword;

	@FindBy(css = ".header-left-menu")
	private WebElement leftSiteMenu;

	@FindBy(xpath = "//*[@class='home slider']")
	private WebElement homeSlider;

	@FindBy(name = "submit")
	private WebElement submitButton;

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public MyProductsPage goToMyProductsPage() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@href='moi-kabinet/moi-produkty/']")));
		this.myPage.click();
		return new MyProductsPage(driver);
	}

	public void clickOnLogout() {
		logout.click();

	}

	public boolean isHomeSliderDisplay() {
		return homeSlider.isDisplayed();
	}

	public boolean isMyDataIconDisplayed() {
		return leftSiteMenu.isDisplayed();
	}

	public boolean IsLoginButtonDisplayed() {
		return submitButton.isDisplayed();
	}

	public ChangePasswordPage changeMyPassword() {
		changePassword.click();
		return new ChangePasswordPage(driver);
	}

	public SiteMenu goToSiteMenu() {
		return new SiteMenu(driver);
	}

}
