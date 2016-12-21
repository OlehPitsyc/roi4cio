package LeftMenu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roi4cio.login.MyProfilePage;

public class SiteMenu {
	private WebDriver driver;

	@FindBy(css = ".poten-user-icon")
	private WebElement potentialUsers;

	@FindBy(css = ".poten-comp-icon ")
	private WebElement potentialSuppliers;

	@FindBy(css = ".poten-mybuyers-icon")
	private WebElement myBuyers;

	public SiteMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public PersonalAnaliticPage  goToPotentialUsersPage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", potentialUsers);
		return new PersonalAnaliticPage (driver);
	}

	public PersonalAnaliticPage  goToPotentialSuppliersPage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", potentialSuppliers);
		return new PersonalAnaliticPage (driver);
	}

	public MyBuyersPage goToMyBuyersPage() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", myBuyers);
		return new MyBuyersPage  (driver);
	}
}
