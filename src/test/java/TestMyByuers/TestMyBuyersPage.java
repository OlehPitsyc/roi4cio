package TestMyByuers;

import static loginData.Users.VALID_USER;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LeftMenu.MyBuyersPage;
import LeftMenu.SiteMenu;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;

public class TestMyBuyersPage {
	private ROI4CIO roi = new ROI4CIO();
	private MyProfilePage myProfilePage;
	private SiteMenu leftMenu;
	private MyBuyersPage myBuyers;

	@BeforeMethod
	private void setUp() {
		myProfilePage = roi.openHomePage().clickOnLoginIcon().loginAs(VALID_USER);
	}

	@Test
	public void verifyIsButtonAddBuyersDisplayed() {
		leftMenu = myProfilePage.goToSiteMenu();
		myBuyers=leftMenu.goToMyBuyersPage();
		Assert.assertTrue(myBuyers.isAddButtonDisplayed(), "Test");
		
	}
}
