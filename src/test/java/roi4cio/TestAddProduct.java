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

public class TestAddProduct {
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
		loginPage = loginIcon.clickOnLoginIcon();
		tableProductPage = loginPage.loginP("opitsyc@gmail.com", "12345678");

	}

	@Test(priority=1)
	public void testAddProduct() {
		addProductToMyList = tableProductPage.goToMyProuctsPage();
		addProduct = addProductToMyList.addProduct();
		addProduct.addTitleForProduct(" svf ", "The Best product in whole");
		addProduct.clickOneToggle();
		addProduct.clickOnCategore();
		addProduct.saveButtonClick();
		Assert.assertTrue(addProduct.myProductsList());
	}
	
	@Test(priority=2)
	public void testAddProductWithSameName() {
		addProductToMyList = tableProductPage.goToMyProuctsPage();
		addProduct = addProductToMyList.addProduct();
		addProduct.addTitleForProduct(" svf ", "The Best product in whole");
		addProduct.clickOneToggle();
		addProduct.clickOnCategore();
		addProduct.saveButtonClick();
		Assert.assertFalse(addProduct.myProductsList(),"Product with the same title couldn't be created");
	}

	@Test
	public void testAddProductWithEmptyCategory() {
		addProductToMyList = tableProductPage.goToMyProuctsPage();
		addProduct = addProductToMyList.addProduct();
		addProduct.addTitleForProduct(" svf ", "The Best product in whole");
		addProduct.clickOneToggle();
		addProduct.saveButtonClick();
		Assert.assertEquals(addProduct.textErrorMessage(),
				"Некоторые ошибки" + "\nКатегория продукта: Задано пустое значение.");

	}

	@Test
		 public void testAddPdocutWithEmptyDeliveryAndCategory() {
		 addProductToMyList = tableProductPage.goToMyProuctsPage();
		 addProduct = addProductToMyList.addProduct();
		 addProduct.addTitleForProduct(" svf ", "The Best product in whole");
		 addProduct.saveButtonClick();
		 Assert.assertEquals(addProduct.textErrorMessage(), "Некоторые ошибки"
		 + "\nТип поставки: Задано пустое значение." + "\nКатегория продукта: Задано пустое значение.");
		 }

	@Test
		 public void testAddProductWithEmptyMandatoryFields() {
		 addProductToMyList = tableProductPage.goToMyProuctsPage();
		 addProduct = addProductToMyList.addProduct();
		 addProduct.addTitleForProduct(" ", " ");
		 addProduct.saveButtonClick();
		 Assert.assertEquals(addProduct.textErrorMessage(), "Некоторые ошибки" +
		 "\nНазвание: Задано пустое значение."
		 + "\nТип поставки: Задано пустое значение." + "\nКатегория продукта: Задано пустое значение.");
		 }
	@Test
	public void testAddProductWithoutCountry() {
		addProductToMyList = tableProductPage.goToMyProuctsPage();
		addProduct = addProductToMyList.addProduct();
		addProduct.addTitleForProduct(" svf14 ", "The Best product in whole");
		addProduct.clickOneToggle();
		addProduct.clickOnCategore();
		addProduct.selectCountry();
		addProduct.saveButtonClick();
		Assert.assertEquals(addProduct.textErrorMessage(),
				"Некоторые ошибки" + "\nСтрана: Задано пустое значение.");
	}
	@Test
	 public void testAddProductWithEmptyAllFields() {
	 addProductToMyList = tableProductPage.goToMyProuctsPage();
	 addProduct = addProductToMyList.addProduct();
	 addProduct.addTitleForProduct(" ", " ");
	 addProduct.selectCountry();
	 addProduct.saveButtonClick();
	 Assert.assertEquals(addProduct.textErrorMessage(), "Некоторые ошибки" +
	 "\nНазвание: Задано пустое значение." + "\nСтрана: Задано пустое значение."
	 + "\nТип поставки: Задано пустое значение." + "\nКатегория продукта: Задано пустое значение.");
	 }
	
	@Test
	 public void testAddProductConfirmationPopup() {
	 addProductToMyList = tableProductPage.goToMyProuctsPage();
	 addProduct = addProductToMyList.addProduct();
	 addProduct.addTitleForProduct("Test ", " ");
	 addProduct.selectCountry();
	 addProduct.clickOnFlag();
	 Assert.assertTrue(addProduct.Popup());
	 }
	
	@Test
	 public void testAddProductCickOnYesInConfirmationPopup() {
	 addProductToMyList = tableProductPage.goToMyProuctsPage();
	 addProduct = addProductToMyList.addProduct();
	 addProduct.addTitleForProduct("Test ", " ");
	 addProduct.selectCountry();
	 addProduct.clickOnFlag();
	 addProduct.clickOnYesButton();
	 Assert.assertTrue(addProduct.englishPageAddProduct());
	 }
	
	@Test
	 public void testAddProductCickOnYesInConfirmationPopupAfterErrors() {
	 addProductToMyList = tableProductPage.goToMyProuctsPage();
	 addProduct = addProductToMyList.addProduct();
	 addProduct.addTitleForProduct("Test ", " ");
	 addProduct.saveButtonClick();
	 try {
		Thread.sleep(2500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 addProduct.clickOneToggle();
	 addProduct.clickOnFlag();
	 addProduct.clickOnYesButton();
	 Assert.assertTrue(addProduct.englishPageAddProduct());
	 }
	
	@Test
	 public void testAddProductWithFilledAllFields() {
	 addProductToMyList = tableProductPage.goToMyProuctsPage();
	 addProduct = addProductToMyList.addProduct();
	 addProduct.addTitleForProduct(" ", " ");
	 addProduct.saveButtonClick();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 addProduct.addTitleForProduct(" TEST1 ", "The Best product in whole");
	 addProduct.clickOneToggle();
	 addProduct.clickOnCategore();
	 addProduct.saveButtonClick();
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Assert.assertTrue(addProduct.myProductsList());
	 }
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi.close();
	}
}


