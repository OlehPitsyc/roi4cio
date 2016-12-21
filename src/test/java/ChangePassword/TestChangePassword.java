package ChangePassword;

import static loginData.Users.VALID_USER;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ChangePasswordPage.ChangePasswordPage;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;

public class TestChangePassword {
	private ROI4CIO roi = new ROI4CIO();
	private MyProfilePage myProfilePage;
	private ChangePasswordPage changePasswordPage;
	

	@BeforeMethod
	private void setUp() {
		myProfilePage = roi.openHomePage().clickOnLoginIcon().loginAs(VALID_USER);	
}
	
	@Test
	public void verifyChangePasswordFormDesplayed(){
		changePasswordPage=myProfilePage.changeMyPassword();
		Assert.assertTrue(changePasswordPage.isPageChangePasswordDisplayed(),"Page ChangePaswword doesn't desplayed");
	}
		
	}
