package ChangePasswordPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[@class='ui teal fluid right labeled icon button']")
	private WebElement buttonSendNewPassword;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public boolean isPageChangePasswordDisplayed() {
		return buttonSendNewPassword.isDisplayed();
	}
}
