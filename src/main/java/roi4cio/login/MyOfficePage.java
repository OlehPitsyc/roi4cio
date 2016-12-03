package roi4cio.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyOfficePage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@href='moi-kabinet/moi-produkty/']")
	private WebElement myPage;
	
	@FindBy (xpath = "(//*[@href='login/?logintype=logout'])[2]")
	private WebElement logout;

	@FindBy(xpath = "//*[@class='right menu']/a")
	private WebElement myData;

	public MyOfficePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	public MyProducts goToMyProuctsPage() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@href='moi-kabinet/moi-produkty/']")));
		this.myPage.click();
		return new MyProducts(driver);
	}
	
	public void clickOnLogout(){
		logout.click();
	}
	

	public boolean myDataIsDisplayed(){
		return myData.isDisplayed();
	}

}
