package roi4cio.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIcon {

	private WebDriver driver;

	@FindBy(className = "circular")
	private WebElement loginLink;

	public LoginIcon(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage clickOnLoginIcon() {
		this.loginLink.click();
		return new LoginPage(driver);
	}

}
