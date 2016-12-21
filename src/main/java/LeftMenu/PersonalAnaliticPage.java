package LeftMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalAnaliticPage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@data-type='potential_user']")
	private WebElement potentialUsersButton;
	
	@FindBy(xpath = "//*[@data-type='potential_supplier']")
	private WebElement potentialSuppliersButton;
	
	public PersonalAnaliticPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public boolean isPotentialUserButtonDisplayed(){
		return potentialUsersButton.isDisplayed();
	}
	
	public boolean isPotentialSupplierButtonDisplayed(){
		return potentialSuppliersButton.isDisplayed();
	}
	
}
