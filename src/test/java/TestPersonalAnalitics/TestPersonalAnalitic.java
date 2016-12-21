package TestPersonalAnalitics;

import static loginData.Users.VALID_USER;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LeftMenu.PersonalAnaliticPage;
import LeftMenu.SiteMenu;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;

public class TestPersonalAnalitic {
	private ROI4CIO roi = new ROI4CIO();
	private MyProfilePage myProfilePage;
	private SiteMenu leftMenu;
	private PersonalAnaliticPage perssonalAnalitic;

	@BeforeMethod
	private void setUp() {
		myProfilePage = roi.openHomePage().clickOnLoginIcon().loginAs(VALID_USER);
	}

	@Test
	public void verifyPotentialSuppliersButtonDisplayed() {
		leftMenu = myProfilePage.goToSiteMenu();
		perssonalAnalitic=leftMenu.goToPotentialSuppliersPage();
		Assert.assertTrue(perssonalAnalitic.isPotentialSupplierButtonDisplayed());
	}

	@Test
	public void verifyPotentialUserButtonDisplayed() {
		leftMenu=myProfilePage.goToSiteMenu();
		perssonalAnalitic=leftMenu.goToPotentialUsersPage();
		Assert.assertTrue(perssonalAnalitic.isPotentialSupplierButtonDisplayed());

	}
}
