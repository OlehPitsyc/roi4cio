package roi4cio.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Properties.Browser;

public class ROI4CIO {

	private WebDriver driver;
	private static final String baseUrl = "http://roi4cio.com/";

	public HomePage openHomePage() {
		driver = Browser.getDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new HomePage(driver);
	}
	public void close() {
		if (this.driver != null)
			this.driver.quit();
		this.driver = null;
	}

}
