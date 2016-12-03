package roi4cio.add.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOfficePage1 {

	private WebDriver driver;

	@FindBy(xpath = "//*[@href='moi-kabinet/moi-produkty/']")
	private WebElement myPage;

	public MyOfficePage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public MyProducts myProd() {
		//driver.findElement(By.xpath("//a[contains(text(),'Мои продукты')]")).click();
		if (this.myPage.isDisplayed()) {
			this.myPage.click();
		}
		else {System.out.println("Error locator");

		}
		return new MyProducts(driver);
	}

}
