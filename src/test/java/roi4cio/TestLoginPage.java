package roi4cio;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import roi4cio.login.AddProductPage;
import roi4cio.login.LoginIcon;
import roi4cio.login.LoginPage;
import roi4cio.login.MyOfficePage;
import roi4cio.login.MyProducts;
import roi4cio.login.ROI4CIO;

public class TestLoginPage {
	private WebDriver driver;
	private ROI4CIO roi = new ROI4CIO();
	private LoginIcon loginIcon;
	private LoginPage loginPage;
	private MyOfficePage tableProductPage;
	private MyProducts addProductToMyList;
	private AddProductPage addProduct;

	@BeforeMethod
	private void setUp() {
		loginIcon = roi.roi4cioHomePage();
	

	}
	
	 @Test
	 public void ValidInputDataForlogin() {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("opitsyc@gmail.com", "12345678");
	 Assert.assertTrue(tableProductPage.myDataIsDisplayed());
	 }
	
	 @Test
	 public void InvalidInputDataForLogin() {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("TEST", "1234567");
	 Assert.assertTrue(loginPage.loginButtonIsDisplayed());
	 }
	 @Test
	 public void LogoutAfterLogin() {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("opitsyc@gmail.com", "12345678");
	 tableProductPage.clickOnLogout();
	 Assert.assertTrue(loginPage.loginFromForInputData());
	 }
	 
	 @Test
	 public void EmailAndPasswordFieldsAreEmpty() {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("", "");
	 Assert.assertTrue(loginPage.loginButtonIsDisplayed());
	 }
	 
	 @Test
	 public void EmailFieldIsEmpty () {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("", "12345678");
	 Assert.assertTrue(loginPage.loginButtonIsDisplayed());
	 }
	 
	 @Test
	 public void PasswordFieldIsEmpty() {
	 loginPage = loginIcon.clickOnLoginIcon();
	 tableProductPage = loginPage.loginP("opitsyc@gmail.com", "");
	 Assert.assertTrue(loginPage.loginButtonIsDisplayed());
	 }

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi.close();
	}
}
