package LeftMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBuyersPage {
	private WebDriver driver;

	@FindBy(css = ".ui.teal")
	private WebElement addMyUsers;

	public MyBuyersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
	}

	public boolean isAddButtonDisplayed() {
		return addMyUsers.isDisplayed();
	}
}
