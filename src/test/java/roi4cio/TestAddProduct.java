package roi4cio;

import static loginData.Users.VALID_USER;
import static roi4cio.add.product.ProductModel.*;
import static roi4cio.add.product.TestData.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import roi4cio.add.product.ProductModel;
import roi4cio.login.AddProductPage;
import roi4cio.login.MyProductsPage;
import roi4cio.login.MyProfilePage;
import roi4cio.login.ROI4CIO;
public class TestAddProduct {

	private ROI4CIO roi = new ROI4CIO();

	private MyProfilePage myProfilePage;
	private MyProductsPage myProductsPage;
	private AddProductPage addProductPage;
	private ProductModel testProduct;

	@BeforeMethod
	private void setUp() {
		myProfilePage = roi.openHomePage().clickOnLoginIcon().loginAs(VALID_USER);
		testProduct = generateProduct();
	}

	private ProductModel generateProduct() {
		return new ProductModel("Soap", "Desktop virtualization", "Appliance");
	}


	@Test(priority = 1)
	public void testAddProduct() {
		addProductPage = myProfilePage.goToMyProductsPage().addProduct();
//		addProductPage.addTitleForProduct("svf", "The Best product in whole");
//		addProductPage.selectDeliveryType();
//		addProductPage.clickOnCategory();
//		myProductsPage = addProductPage.save();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(myProductsPage.productNameList().contains("svf"));
//		// Assert.assertTrue(addProductPage.myProductsList());

		addProductPage.addAroduct(FilledAllMandatoryFields);
		addProductPage.save();
		//Assert.assertTrue(myProductsPage.productNameList().contains(testProduct));
	}

	@Test(priority = 2)
	public void testAddProductWithSameName() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" svf ", "The Best product in whole");
		addProductPage.selectDeliveryType();
		addProductPage.clickOnCategory();
		addProductPage.clickSaveButton();
		Assert.assertFalse(addProductPage.myProductsList(), "Product with the same title couldn't be created");
	}

	@Test
	public void testAddProductWithEmptyCategory() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" svf ", "The Best product in whole");
		addProductPage.selectDeliveryType();
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				"Некоторые ошибки" + "\nКатегория продукта: Задано пустое значение.");

	}

	@Test
	public void testAddPdocutWithEmptyDeliveryAndCategory() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" svf ", "The Best product in whole");
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(), "Некоторые ошибки"
				+ "\nТип поставки: Задано пустое значение." + "\nКатегория продукта: Задано пустое значение.");
	}

	@Test
	public void testAddProductWithEmptyMandatoryFields() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" ", " ");
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				"Некоторые ошибки" + "\nНазвание: Задано пустое значение." + "\nТип поставки: Задано пустое значение."
						+ "\nКатегория продукта: Задано пустое значение.");
	}

	@Test
	public void testAddProductWithoutCountry() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" svf14 ", "The Best product in whole");
		addProductPage.selectDeliveryType();
		addProductPage.clickOnCategory();
		addProductPage.selectValueFromDropdawnCategory("Безопасность");
		addProductPage.selectCountry();
		//addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				"Некоторые ошибки" + "\nСтрана: Задано пустое значение.");
	}

	@Test
	public void testAddProductWithEmptyAllFields() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" ", " ");
		addProductPage.selectCountry();
		addProductPage.clickSaveButton();
		Assert.assertEquals(addProductPage.textErrorMessage(),
				"Некоторые ошибки" + "\nНазвание: Задано пустое значение." + "\nСтрана: Задано пустое значение."
						+ "\nТип поставки: Задано пустое значение." + "\nКатегория продукта: Задано пустое значение.");
	}

	@Test
	public void testAddProductConfirmationPopup() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct("Test ", " ");
		addProductPage.selectCountry();
		addProductPage.clickOnFlag();
		Assert.assertTrue(addProductPage.Popup());
	}

	@Test
	public void testAddProductCickOnYesInConfirmationPopup() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct("Test ", " ");
		addProductPage.selectCountry();
		addProductPage.clickOnFlag();
		addProductPage.clickOnYesButton();
		Assert.assertTrue(addProductPage.englishPageAddProduct());
	}

	@Test
	public void testAddProductCickOnYesInConfirmationPopupAfterErrors() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct("Test ", " ");
		addProductPage.clickSaveButton();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addProductPage.selectDeliveryType();
		addProductPage.clickOnFlag();
		addProductPage.clickOnYesButton();
		Assert.assertTrue(addProductPage.englishPageAddProduct());
	}

	@Test
	public void testAddProductWithFilledAllFields() {
		myProductsPage = myProfilePage.goToMyProductsPage();
		addProductPage = myProductsPage.addProduct();
		addProductPage.addTitleForProduct(" ", " ");
		addProductPage.clickSaveButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addProductPage.addTitleForProduct(" TEST1 ", "The Best product in whole");
		addProductPage.selectDeliveryType();
		addProductPage.clickOnCategory();
		addProductPage.clickSaveButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(addProductPage.myProductsList());
	}

//	@AfterMethod(alwaysRun = true)
//	public void tearDown() {
//		roi.close();
//	}
}
