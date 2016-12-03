package roi4cio.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import roi4cio.add.product.MyOfficePage1;

public class LoginPage {
	private WebDriver driver;

	@FindBy(name = "user")
	private WebElement login;

	@FindBy(name = "pass")
	private WebElement password;

	@FindBy(name = "submit")
	private WebElement submitButton;

	@FindBy(className = "four fields")
	private WebElement errorMessage;
	@FindBy(className = "segment")
	private WebElement loginForm;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public MyOfficePage loginP(String emails, String pass) {
		login.sendKeys(emails);
		password.sendKeys(pass);
		submitButton.click();
		return new MyOfficePage(driver);
	}

	public String error() {
		return errorMessage.getText();

	}

	public boolean loginButtonIsDisplayed() {
		return submitButton.isDisplayed();
	}

	public boolean loginFromForInputData() {
		return loginForm.isDisplayed();
	}
}
