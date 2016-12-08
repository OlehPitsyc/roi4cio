package roi4cio;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import roi4cio.login.HomePage;
import roi4cio.login.LoginPage;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;
import static loginData.Users.*;

public class TestLoginPage {
	
	private ROI4CIO roi = new ROI4CIO();
	private HomePage homePage;
	private LoginPage loginPage;
	private MyProfilePage myProfilePage;
	

	@BeforeMethod
	private void setUp() {
		homePage = roi.openHomePage();
	

	}
	
	 @Test
	 public void validInputDataForlogin() {
	 myProfilePage = homePage.clickOnLoginIcon().loginAs(VALID_USER);
	 Assert.assertTrue(myProfilePage.isMyDataIconDisplayed());
	 }
	
	 @Test
	 public void invalidInputDataForLogin() {
	 myProfilePage = homePage.clickOnLoginIcon().loginAs(INVALID_USER); 
	 Assert.assertTrue(myProfilePage.IsLoginButtonDisplayed());
	 }
	 
	 @Test
	 public void logoutAfterLogin() {
	 myProfilePage = homePage.clickOnLoginIcon().loginAs(VALID_USER);
	 myProfilePage.clickOnLogout();
	 Assert.assertTrue( myProfilePage.isHomeSliderDisplay());
	 }
	 
	 @Test
	 public void emailAndPasswordFieldsAreEmpty() {
	 myProfilePage = homePage.clickOnLoginIcon().loginAs("", "");
	 Assert.assertTrue(myProfilePage.IsLoginButtonDisplayed());
	 }
	 
	 @Test
	 public void emailFieldIsEmpty () {
	 myProfilePage =  homePage.clickOnLoginIcon().loginAs("", "12345678");
	 Assert.assertTrue(myProfilePage.IsLoginButtonDisplayed());
	 }
	 
	 @Test
	 public void PasswordFieldIsEmpty() {
	 myProfilePage = homePage.clickOnLoginIcon().loginAs("opitsyc@gmail.com", "");
	 Assert.assertTrue(myProfilePage.IsLoginButtonDisplayed());
	 }

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi.close();
	}
}
